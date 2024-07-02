package com.cqdx.nobug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqdx.nobug.entity.Email;
import jakarta.mail.internet.AddressException;


import java.io.UnsupportedEncodingException;



public interface EmailService extends IService<Email> {
    public void sendEmail(String to, String subject, String text) throws UnsupportedEncodingException, AddressException;
    public String generateRandomString(int length);
}
