CREATE SCHEMA if not exists psychology;

CREATE TABLE psychology.order
(
    id          INT         NOT NULL AUTO_INCREMENT,
    date_create DATETIME    NOT NULL,
    user_id_psc INT         NOT NULL,
    user_id_pat INT         NOT NULL,
    date_meting DATETIME    NOT NULL,
    date_done   VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE psychology.user
(
    id            INT         NOT NULL AUTO_INCREMENT COMMENT '',
    uuid_id       BINARY(16)  NOT NULL COMMENT '',
    name          VARCHAR(45) NOT NULL COMMENT '',
    firstname     VARCHAR(45) NULL COMMENT '',
    email         VARCHAR(45) NOT NULL COMMENT '',
    lang          VARCHAR(45) NULL COMMENT '',
    last_activity DATETIME    NOT NULL DEFAULT now() COMMENT '',
    type          VARCHAR(45) NOT NULL COMMENT '',
    PRIMARY KEY (id) COMMENT ''
);

