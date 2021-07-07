package com.psychology.notificationsservice.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface Sending {
    public JavaMailSender sendMessages();
}
