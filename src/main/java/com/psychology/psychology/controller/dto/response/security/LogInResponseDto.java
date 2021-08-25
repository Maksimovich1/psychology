package com.psychology.psychology.controller.dto.response.security;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author andrew.maksimovich
 */
@AllArgsConstructor
@Data
public class LogInResponseDto {
    public String accessToken;
    public String refreshToken;
}
