package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author andrew.maksimovich
 */
@Getter
@Setter
@Entity
@Table(name = "secure", schema = "psychology")
public class SecureObject extends DomainObject {
    @Column(unique = true)
    private String login;
    private byte[] password;
    private byte[] salt;

    /**
     * Тип пользователя: врач или пациент администратор и т.д
     * тоже дожнен быть справочник
     */
    @Enumerated(EnumType.STRING)
    private Role role;
}
