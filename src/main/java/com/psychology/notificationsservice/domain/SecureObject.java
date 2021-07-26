package com.psychology.notificationsservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author andrew.maksimovich
 */
@Getter
@Setter
@Entity
@Table(name = "secure", schema = "psychology")
public class SecureObject extends DomainObject{
    private String login;
    private String password;
    private LocalDateTime lastActivity;
}
