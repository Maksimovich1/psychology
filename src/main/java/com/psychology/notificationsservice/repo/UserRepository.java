package com.psychology.notificationsservice.repo;

import com.psychology.notificationsservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrew.maksimovich
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
