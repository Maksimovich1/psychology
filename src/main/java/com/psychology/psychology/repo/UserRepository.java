package com.psychology.psychology.repo;

import com.psychology.psychology.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrew.maksimovich
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
