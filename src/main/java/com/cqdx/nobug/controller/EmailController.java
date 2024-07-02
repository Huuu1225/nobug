package com.cqdx.nobug.controller;

import com.cqdx.nobug.entity.Email;
import com.cqdx.nobug.service.EmailService;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController// Controller
@RequestMapping("/user")

//我的Hbuilder上端口为8081，如果web上端口为8080可忽略这条语句
//@CrossOrigin(origins = "http://localhost:8081")

public class EmailController {
    @Autowired
    public EmailService userService;


    @PostMapping("/sendEmail")
    public String sendEmail(Email email) throws AddressException, UnsupportedEncodingException {
        String to = email.getEmail();
        String subject = "注册验证";
        String YanZhengCode = userService.generateRandomString(6);
        String content = "验证码为：" + YanZhengCode;
        userService.sendEmail(to,subject,content);

        return "yes";
    }

}
