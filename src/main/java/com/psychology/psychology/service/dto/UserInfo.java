package com.psychology.psychology.service.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author andrew.maksimovich
 */
@Data
public class UserInfo {
    private String login;
    private String name;
    private String surname;
    private UUID uuid;
}
