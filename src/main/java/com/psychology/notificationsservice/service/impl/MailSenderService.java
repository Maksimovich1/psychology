package com.psychology.notificationsservice.service.impl;

import com.psychology.notificationsservice.service.Sending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements Sending {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendMessages(String mailAddress, String textMail, String subject)  {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(textMail);
        emailSender.send(simpleMailMessage);

    }
}

