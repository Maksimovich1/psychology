package com.psychology.psychology.exception.response.dto;

import lombok.Data;

/**
 * @author andrew.maksimovich
 */
@Data
public class ErrorBody {
    private String message;
    private String detailMassage;
}
