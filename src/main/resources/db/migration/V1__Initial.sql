CREATE SCHEMA if not exists psychology;

CREATE TABLE psychology.orders
(
    id           bigserial NOT NULL,
    date_create  timestamp NOT NULL,
    user_id_doc  bigint    NOT NULL,
    user_id_pat  bigint    NOT NULL,
    date_meeting timestamp NOT NULL,
    is_completed boolean   NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.users
(
    id            bigserial   NOT NULL,
    uuid_id       uuid        NOT NULL,
    name_user     VARCHAR(50) NOT NULL,
    firstname     VARCHAR(50) NULL,
    email         VARCHAR(50) NOT NULL,
    lang          VARCHAR(50) NULL,
    last_activity timestamp   NOT NULL,
    secure_id     bigint      not null,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.clients
(
    id            bigserial   NOT NULL,
    user_id       bigint      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.doctors
(
    id            bigserial   NOT NULL,
    user_id       bigint      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.secure
(
    id       bigserial    NOT NULL,
    login    VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    salt     varchar(50)  not null,
    PRIMARY KEY (id)
);

alter table psychology.orders
    add constraint pat_user_id foreign key (user_id_pat) references psychology.users (id);

alter table psychology.orders
    add constraint user_id_doc foreign key (user_id_doc) references psychology.users (id);

alter table psychology.users
    add constraint secure_foreign_key_id foreign key (secure_id) references psychology.secure (id);

alter table psychology.clients
    add constraint clients_user_id foreign key (user_id) references psychology.users (id);

alter table psychology.doctors
    add constraint doctors_user_id foreign key (user_id) references psychology.users (id);


