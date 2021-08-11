package com.psychology.psychology.controller.dto.request.security;

import lombok.Data;

/**
 * @author andrew.maksimovich
 */
@Data
public class RegistrationRequestDto {
    private String firstName;
    private String secondName;
    /**
     * Тип доктор или пациент
     */
    private String type;
    private String login;
    /**
     * Пароль должен быть уже подсолен и хеширован!
     */
    private String password;

    private String email;
    /**
     * TODO это относится только к врачам не реализовано пока!
     */
    private String specialisation;
}
