package com.psychology.psychology.repo;

import com.psychology.psychology.domain.Doctor;

import java.util.List;

/**
 * @author andrew.maksimovich
 */

public interface DoctorRepository {
    List<Doctor> findAll();
}
