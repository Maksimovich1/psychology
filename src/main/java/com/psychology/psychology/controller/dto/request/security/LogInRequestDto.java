package com.psychology.psychology.controller.dto.request.security;

import lombok.Data;

/**
 * @author andrew.maksimovich
 */
@Data
public class LogInRequestDto {
    private String login;
    private String password;
}
