package com.psychology.notificationsservice.controller.dto.request;

/**
 * @author andrew.maksimovich
 */

public class NotificationRequestDto {
    private String email;
    private String textMail;
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextMail() {
        return textMail;
    }

    public void setTextMail(String textMail) {
        this.textMail = textMail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
