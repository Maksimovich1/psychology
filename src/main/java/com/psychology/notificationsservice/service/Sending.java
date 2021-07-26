package com.psychology.notificationsservice.service;

import org.springframework.mail.MailException;

public interface Sending  {
    void sendMessages(String mailAddress, String textMail, String subject) throws MailException; // вопрос по исключениям
    //todo понять разницу в checked и unchecked и нужно ли тут бросать его?
}
