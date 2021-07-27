package com.psychology.psychology.service;

import org.springframework.mail.MailException;

public interface Sending  {
    void sendMessages(String mailAddress, String textMail, String subject) throws MailException;
}
