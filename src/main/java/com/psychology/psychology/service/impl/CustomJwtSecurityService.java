package com.psychology.psychology.service.impl;

import com.psychology.psychology.controller.dto.request.security.ForgotPasswordRequestDto;
import com.psychology.psychology.controller.dto.request.security.LogInRequestDto;
import com.psychology.psychology.controller.dto.request.security.RegistrationRequestDto;
import com.psychology.psychology.controller.dto.response.security.LogInResponseDto;
import com.psychology.psychology.domain.SecureObject;
import com.psychology.psychology.domain.User;
import com.psychology.psychology.exception.AppsAuthPsychologyException;
import com.psychology.psychology.exception.AppsPsychologyRuntimeException;
import com.psychology.psychology.repo.SecureRepository;
import com.psychology.psychology.repo.UserRepository;
import com.psychology.psychology.security.JwtTokenProvider;
import com.psychology.psychology.security.PasswordService;
import com.psychology.psychology.service.SecurityService;
import com.psychology.psychology.service.dto.UserInfo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

/**
 * @author andrew.maksimovich
 */
@Service
@RequiredArgsConstructor
public class CustomJwtSecurityService implements SecurityService {

    private final UserRepository userRepository;
    private final SecureRepository secureRepository;
    private final PasswordService passwordService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String getSalt(String login) {
        return null;
    }

    @Override
    @Transactional
    public void registration(@NonNull RegistrationRequestDto registrationRequestDto) {
        isAvailableLogin(registrationRequestDto.getLogin());

        byte[] salt = passwordService.getNextSalt();
        byte[] hash = passwordService.hash(registrationRequestDto.getPassword(), salt);

        // пока нет мапперов оставлю это здесь
        User user = new User();
        user.setCreateDate(LocalDateTime.now());
        user.setEmail(registrationRequestDto.getEmail());
        user.setFirstName(registrationRequestDto.getFirstName());
        user.setSecondName(registrationRequestDto.getSecondName());
        user.setLastActivity(LocalDateTime.now());
        user.setUuid(UUID.randomUUID());
        SecureObject secure = new SecureObject();
        secure.setLogin(registrationRequestDto.getLogin());
        secure.setPassword(hash);
        secure.setSalt(salt);
        secure.setRole(registrationRequestDto.getRole());
        user.setSecure(secure);
        userRepository.save(user);
    }

    @Override
    public LogInResponseDto login(@NonNull LogInRequestDto logInRequestDto) {
        SecureObject secureObject = secureRepository.findByLogin(logInRequestDto.getLogin());
        if (!passwordService.isExpectedPassword(logInRequestDto.getPassword(), secureObject.getSalt(), secureObject.getPassword())) {
            throw new AppsAuthPsychologyException();
        }
        String token = jwtTokenProvider.generateAccessToken(logInRequestDto.getLogin(), Collections.emptyList());
        //TODO нужно генерировать accsess токен и записывать его в бд
        return new LogInResponseDto(token, null);
    }

    @Override
    public void forgot(ForgotPasswordRequestDto forgotPasswordRequestDto) {

    }

    @Override
    public UserInfo getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User userByLogin = userRepository.getUserByLogin(login);
        //TODO нужно сделать маппер
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin(login);
        userInfo.setName(userByLogin.getFirstName());
        userInfo.setSurname(userByLogin.getSecondName());
        return userInfo;
    }

    private void isAvailableLogin(@NonNull String login) {
        boolean existsByLogin = secureRepository.existsByLogin(login.trim());
        if (existsByLogin) {
            throw new AppsPsychologyRuntimeException(() -> "Такой логин уже занят!");
        }
    }
}
