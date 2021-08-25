package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
}
