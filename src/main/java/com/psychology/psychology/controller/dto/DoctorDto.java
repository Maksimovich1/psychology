package com.psychology.psychology.controller.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author andrew.maksimovich
 */
@Data
public class DoctorDto {
    private String name;
    private String surname;
    private String specialisation;
    private UUID id;
    private String currency;
    private String priceForOneHour;
}
