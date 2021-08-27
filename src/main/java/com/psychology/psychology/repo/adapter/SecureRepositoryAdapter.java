package com.psychology.psychology.repo.adapter;

import com.psychology.psychology.domain.SecureObject;
import com.psychology.psychology.exception.AppsAuthPsychologyException;
import com.psychology.psychology.repo.SecureRepository;
import com.psychology.psychology.repo.jpa.SecureJpaRepository;
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
public class SecureRepositoryAdapter implements SecureRepository {

    private final SecureJpaRepository secureJpaRepository;

    @Override
    public SecureObject findByLogin(String login) {
        return secureJpaRepository.findByLogin(login).orElseThrow(AppsAuthPsychologyException::new);
    }

    @Override
    public boolean existsByLogin(@NonNull String login) {
        return secureJpaRepository.existsByLogin(login);
    }
}
