package com.psychology.psychology.controller.dto.response.security;

import lombok.Data;

/**
 * @author andrew.maksimovich
 */
@Data
public class LogInResponseDto {
    public String accessToken;
    public String refreshToken;
}
