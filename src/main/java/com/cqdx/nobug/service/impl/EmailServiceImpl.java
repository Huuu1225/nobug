package com.cqdx.nobug.service.iml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqdx.nobug.entity.Email;
import com.cqdx.nobug.mapper.EmailDao;
import com.cqdx.nobug.service.EmailService;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Date;

//邮件包

//生成随机字符串
import java.util.Random;

@Service
public class EmailServiceImpl extends ServiceImpl<EmailDao, Email> implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String to, String subject, String text) throws UnsupportedEncodingException, AddressException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(new InternetAddress(MimeUtility.encodeText("重庆大学校园服务系统")+"<759945999@qq.com>").toString());
        message.setTo(to);
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    //生成随机字符串
    private final String CHARACTERS = "123456789abcdefghijklmnopqrstuvwxyz";
    private Random random = new Random();
    public String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
