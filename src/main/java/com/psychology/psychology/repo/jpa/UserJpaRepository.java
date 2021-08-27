package com.psychology.psychology.repo.jpa;

import com.psychology.psychology.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author andrew.maksimovich
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u, SecureObject s where s.login = :login")
    Optional<User> getUserByLogin(String login);

}
