package com.psychology.psychology.repo.adapter;

import com.psychology.psychology.domain.User;
import com.psychology.psychology.exception.AppsPsychologyRuntimeException;
import com.psychology.psychology.repo.UserRepository;
import com.psychology.psychology.repo.jpa.UserJpaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

/**
 * @author andrew.maksimovich
 */
@Repository
@RequiredArgsConstructor
@Log4j2
public class UserRepositoryAdapter implements UserRepository {


    private final UserJpaRepository userJpaRepository;

    @Override
    public User getUserByLogin(@NonNull String login) {
        return userJpaRepository.getUserByLogin(login)
                .orElseThrow(() -> new AppsPsychologyRuntimeException(() -> "Пользователь не найден по логину " + login));
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }
}
