package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author andrew.maksimovich
 */
@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor extends DomainObject {
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Specialisation specialisation;

    /**
     * Цена за прием
     * будет по умолчанию умножаться на 100 для достижения точности
     * пример 15,23 = 1523
     */
    private long price;
}
