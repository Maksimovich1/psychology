package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность представляет заказ услуги врача
 *
 * @author andrew.maksimovich
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

    @Column(name = "is_completed")
    private boolean isComplete;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    /**
     * todo Язык который будет использоваться пользователем на приеме
     */
    private String lang; // тут хорошо бы иметь енам или справочник
}
