package com.psychology.psychology.repo.adapter;

import com.psychology.psychology.domain.Doctor;
import com.psychology.psychology.repo.DoctorRepository;
import com.psychology.psychology.repo.jpa.DoctorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andrew.maksimovich
 */
@Repository
@RequiredArgsConstructor
public class DoctorRepositoryImpl implements DoctorRepository {

    private final DoctorJpaRepository doctorJpaRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorJpaRepository.findAll();
    }
}
