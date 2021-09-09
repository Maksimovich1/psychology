package com.psychology.psychology.repo.jpa;

import com.psychology.psychology.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrew.maksimovich
 */

public interface DoctorJpaRepository extends JpaRepository<Doctor, Long> {
}
