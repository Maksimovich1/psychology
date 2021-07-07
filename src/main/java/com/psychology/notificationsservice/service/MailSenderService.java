package com.psychology.notificationsservice.service;

import com.psychology.notificationsservice.controller.dto.request.NotificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService implements Sending {

    @Autowired
    MailSender mailSender;

    @Override
    public void sendMessages(String recipient, String message) {
        NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            String from = "maksim02.v@gmail.com";
            String subject = "Test subject";
            mail.setFrom(from);
            mail.setTo(recipient);
            mail.setSubject(subject);
            mail.setText(message);
            mailSender.send(mail);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
    }

