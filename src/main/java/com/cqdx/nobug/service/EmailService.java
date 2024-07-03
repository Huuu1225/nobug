package com.cqdx.nobug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqdx.nobug.entity.Email;
import jakarta.mail.internet.AddressException;
import org.springframework.stereotype.Service;


import java.io.UnsupportedEncodingException;


@Service
public interface EmailService extends IService<Email> {
    public void sendEmail(String to, String subject, String text) throws UnsupportedEncodingException, AddressException;
    public String generateRandomString(int length);
}
