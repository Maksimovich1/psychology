package com.psychology.psychology.controller;

import com.psychology.psychology.controller.dto.DoctorDto;
import com.psychology.psychology.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final ModelMapper modelMapper;

    @GetMapping
    @Operation(summary = "Получение всего списка докторов", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok(
                doctorService.getAllDoctors()
                        .stream()
                        .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                        .collect(Collectors.toList())
        );
    }
}
