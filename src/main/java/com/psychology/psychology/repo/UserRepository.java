package com.psychology.psychology.repo;

import com.psychology.psychology.domain.User;

/**
 * @author andrew.maksimovich
 */

public interface UserRepository {

    User getUserByLogin(String login);

    User save(User user);

}
