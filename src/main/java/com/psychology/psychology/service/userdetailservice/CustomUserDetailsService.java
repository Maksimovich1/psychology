package com.psychology.psychology.service.userdetailservice;

import com.psychology.psychology.domain.User;
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

    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User userByLogin = userRepository.getUserByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect login or password"));
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userByLogin.getSecure());
    }
}
