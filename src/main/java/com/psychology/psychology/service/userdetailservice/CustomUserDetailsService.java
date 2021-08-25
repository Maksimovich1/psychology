package com.psychology.psychology.service.userdetailservice;

import com.psychology.psychology.domain.SecureObject;
import com.psychology.psychology.domain.User;
import com.psychology.psychology.repo.SecureRepository;
import com.psychology.psychology.repo.UserRepository;
import com.psychology.psychology.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author andrew.maksimovich
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final SecureRepository secureRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        SecureObject secureObject = secureRepository.findByLogin(login).orElseThrow();
        return CustomUserDetails.fromUserEntityToCustomUserDetails(secureObject);
    }
}
