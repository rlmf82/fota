CREATE SCHEMA fota AUTHORIZATION sa;

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE fota.user (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  login VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);