package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.Email;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Verification;
import com.cqdx.nobug.service.EmailService;
import com.cqdx.nobug.service.VerificationService;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController// Controller
@RequestMapping("/student")


//我的Hbuilder上端口为8081，如果web上端口为8080可忽略这条语句
@CrossOrigin(origins = "http://localhost:5173")

public class EmailController {
    @Autowired
    public EmailService emailService;
    @Autowired
    public VerificationService verificationService;


    @PostMapping("/sendEmail")
    public Result<Email> sendEmail(@RequestBody Email email) throws AddressException, UnsupportedEncodingException {
        String to = email.getEmail();
        String subject = "注册验证";
        String YanZhengCode = emailService.generateRandomString(6);
        String content = "验证码为：" + YanZhengCode;
        emailService.sendEmail(to,subject,content);
        QueryWrapper<Verification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email.getEmail());
        long count = verificationService.count(queryWrapper);
        if(count==0){
            verificationService.save(new Verification(email.getEmail(),YanZhengCode));
        }else{
            verificationService.update(new Verification(email.getEmail(),YanZhengCode),queryWrapper);
        }

        return Result.success();
    }

}
