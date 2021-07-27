package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author andrew.maksimovich
 * Сущность представляет заказ услуги врача
 * TODO еще нужно добавить платежи как минимум!
 */
@Getter
@Setter
@Entity
@Table(name = "orders", schema = "psychology")
public class Order extends DomainObject {

    @Column(name = "date_create")
    private LocalDateTime dateCreateOrder;

    @Column(name = "date_meeting")
    private LocalDateTime dateMeeting;

    @ManyToOne
    @JoinColumn(name = "user_id_doc", nullable = false)
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "user_id_pat", nullable = false)
    private User client;

    @Column(name = "date_completed")
    private boolean isComplete;
}
