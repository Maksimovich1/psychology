package com.psychology.psychology.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    private String name;

    private String firstName;

    private String email; // возможно нужна таблица, а может и нет нужно помыслить

    /**
     * todo Язык который будет использоваться пользователем на приеме (хотя тогда это нужно в заказ перенести )
     */
    private String lang; // тут хорошо бы иметь енам или справочник

    /**
     * Тип пользователя: врач или пациент администратор и т.д
     * тоже дожнен быть справочник
     */
    private String type;

    @OneToOne
    @JoinColumn(name = "secure_id", referencedColumnName = "id")
    private SecureObject secure;
}
