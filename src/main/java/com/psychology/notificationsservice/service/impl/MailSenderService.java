package com.psychology.notificationsservice.service.impl;

import com.psychology.notificationsservice.service.Sending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements Sending {

    public static final String MY_EMAIL = "maksim02.v@gmail.com";
    public static final String MY_PASSWORD = "41onifer";

    @Autowired
    MailSender mailSender;

    @Override
    public JavaMailSender sendMessages() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(MY_EMAIL);
        mailSender.setPassword(MY_PASSWORD);

        return mailSender;
        }
    }

