package com.psychology.psychology.repo;

import com.psychology.psychology.domain.SecureObject;

/**
 * @author andrew.maksimovich
 */

public interface SecureRepository {
    SecureObject findByLogin(String login);

    boolean existsByLogin(String login);
}
