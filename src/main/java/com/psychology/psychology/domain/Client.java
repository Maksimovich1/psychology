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
@Table(name = "clients")
@Entity
@Getter
@Setter
public class Client extends DomainObject{
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

