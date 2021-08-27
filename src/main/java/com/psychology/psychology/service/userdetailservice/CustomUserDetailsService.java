package com.psychology.psychology.service.userdetailservice;

import com.psychology.psychology.domain.SecureObject;
import com.psychology.psychology.domain.User;
import com.psychology.psychology.repo.SecureRepository;
import com.psychology.psychology.repo.UserRepository;
import com.psychology.psychology.security.CustomUserDetails;
import com.psychology.psychology.service.UserSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author andrew.maksimovich
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService, UserSettingsService {

    private final SecureRepository secureRepository;
    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        SecureObject secureObject = secureRepository.findByLogin(login);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(secureObject);
    }

    @Override
    public void updateLastActivity(String login) {
        User userByLogin = userRepository.getUserByLogin(login);
        userByLogin.setLastActivity(LocalDateTime.now());
        userRepository.save(userByLogin);
    }
}
