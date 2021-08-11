package com.psychology.psychology.service;

import com.psychology.psychology.controller.dto.request.security.ForgotPasswordRequestDto;
import com.psychology.psychology.controller.dto.request.security.LogInRequestDto;
import com.psychology.psychology.controller.dto.request.security.RegistrationRequestDto;
import com.psychology.psychology.controller.dto.response.security.LogInResponseDto;

/**
 * @author andrew.maksimovich
 */

public interface SecurityService {

    String getSalt(String login);

    void registration(RegistrationRequestDto registrationRequestDto);

    LogInResponseDto login(LogInRequestDto logInRequestDto);

    void forgot(ForgotPasswordRequestDto forgotPasswordRequestDto);
}
