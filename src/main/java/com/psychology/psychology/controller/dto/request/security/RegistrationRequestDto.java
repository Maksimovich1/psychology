package com.psychology.psychology.controller.dto.request.security;

import com.psychology.psychology.domain.Role;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author andrew.maksimovich
 */
@Data
public class RegistrationRequestDto {
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String secondName;
    /**
     * Тип доктор или пациент
     */
    private Role role;
    @NotNull
    @NotEmpty
    private String login;
    /**
     * Пароль должен быть уже подсолен и хеширован!
     */
    @NotNull
    private char[] password;

    /**
     * ключ используется для дешифровки TODO пока не уверен что он понадобится
     */
    public String publicKey;

    @NotEmpty
    @NotNull
    private String email;
    /**
     * TODO это относится только к врачам не реализовано пока!
     */
    private String specialisation;
}
