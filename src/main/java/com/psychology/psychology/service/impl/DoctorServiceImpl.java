package com.psychology.psychology.service.impl;

import com.psychology.psychology.domain.Doctor;
import com.psychology.psychology.repo.DoctorRepository;
import com.psychology.psychology.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author andrew.maksimovich
 */
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
