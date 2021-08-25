package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author andrew.maksimovich
 */
@Entity
@Getter
@Setter
@Table(name = "users", schema = "psychology")
public class User extends DomainObject {

    @Column(name = "uuid_id")
    private UUID uuid;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "first_name")
    private String firstName;

    private String email;

    @Column(name = "last_activity")
    private LocalDateTime lastActivity;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "secure_id", referencedColumnName = "id")
    private SecureObject secure;
}
