package com.psychology.psychology.repo.jpa;

import com.psychology.psychology.domain.SecureObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author andrew.maksimovich
 */

public interface SecureJpaRepository extends JpaRepository<SecureObject, Long> {
    boolean existsByLogin(String login);

    Optional<SecureObject> findByLogin(String login);

}
