package com.psychology.notificationsservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author andrew.maksimovich
 */
@Getter
@Setter
@EqualsAndHashCode
public abstract class DomainObject {
    private int id;
}
