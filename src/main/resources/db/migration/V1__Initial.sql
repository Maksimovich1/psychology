CREATE SCHEMA if not exists psychology;

CREATE TABLE psychology.orders
(
    id             LONG        NOT NULL AUTO_INCREMENT,
    date_create    DATETIME    NOT NULL,
    user_id_doc    long        NOT NULL,
    user_id_pat    long        NOT NULL,
    date_meeting   DATETIME    NOT NULL,
    date_completed VARCHAR(45) NULL,
    secure_id      long        not null,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.users
(
    id            long        NOT NULL AUTO_INCREMENT,
    uuid_id       BINARY(16)  NOT NULL,
    name_user     VARCHAR(45) NOT NULL,
    firstname     VARCHAR(45) NULL,
    email         VARCHAR(45) NOT NULL,
    lang          VARCHAR(45) NULL,
    last_activity DATETIME    NOT NULL DEFAULT now(),
    type          VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PSYCHOLOGY.secure
(
    id            long        NOT NULL AUTO_INCREMENT,
    login         VARCHAR(50) NOT NULL,
    password      VARCHAR(50) NOT NULL,
    last_activity datetime,
    PRIMARY KEY (id)
);

alter table psychology.orders
    add constraint pat_user_id foreign key (user_id_pat) references psychology.users(id);

alter table psychology.orders
    add constraint user_id_doc foreign key (user_id_doc) references psychology.users(id);

alter table psychology.orders
    add constraint secure_foreign_key_id foreign key (secure_id) references psychology.secure(id);


