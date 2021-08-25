package com.psychology.psychology.repo;

import com.psychology.psychology.domain.SecureObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author andrew.maksimovich
 */

public interface SecureRepository extends JpaRepository<SecureObject, Long> {
    boolean existsByLogin(String login);

    Optional<SecureObject> findByLogin(String login);

}
