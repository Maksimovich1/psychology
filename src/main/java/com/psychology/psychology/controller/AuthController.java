package com.psychology.psychology.controller;

import com.psychology.psychology.controller.dto.request.security.ForgotPasswordRequestDto;
import com.psychology.psychology.controller.dto.request.security.GetSaltRequestDto;
import com.psychology.psychology.controller.dto.request.security.LogInRequestDto;
import com.psychology.psychology.controller.dto.request.security.RegistrationRequestDto;
import com.psychology.psychology.controller.dto.response.security.LogInResponseDto;
import com.psychology.psychology.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/notification/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SecurityService securityService;

    @PostMapping("/salt")
    public ResponseEntity<String> getSalt(@RequestBody GetSaltRequestDto saltRequestDto) {

        return ResponseEntity.ok(securityService.getSalt(saltRequestDto.getLogin()));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegistrationRequestDto registrationRequestDto){
        //TODO нужно будет сделать маперы
        securityService.registration(registrationRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDto> registerUser(@RequestBody LogInRequestDto logInRequestDto){
        //TODO нужно будет сделать маперы
        return ResponseEntity.ok(securityService.login(logInRequestDto));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody ForgotPasswordRequestDto forgotPasswordRequestDto){
        //TODO нужно будет сделать маперы
        securityService.forgot(forgotPasswordRequestDto);
        return ResponseEntity.ok().build();
    }

}
