package com.psychology.notificationsservice.controller.dto.request;

import lombok.Data;

/**
 * Пока содержит предположительные поля
 *
 * @author andrew.maksimovich
 */
@Data
public class PayRequestSubscribeDto {
    private String typeSub;
    private int during;
}
