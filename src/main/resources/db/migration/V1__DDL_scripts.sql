
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE user (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  login VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE artifact (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  artifact_type VARCHAR(8) NOT NULL,
  code VARCHAR(6) NOT NULL,
  UNIQUE KEY ARTIFACT_UNIQUE_CODE (code)
);

CREATE TABLE feature_requirement (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY
);

CREATE TABLE feature_requirement_artifact(
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  feature_requirement_id BIGINT NOT NULL,
  required_artifact_id BIGINT,
  forbidden_artifact_id BIGINT,
  foreign key (feature_requirement_id) references feature_requirement(id)
);

CREATE TABLE property(
  key VARCHAR(30) NOT NULL,
  value VARCHAR(400) NOT NULL
);

CREATE TABLE truck (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  vin VARCHAR(17) NOT NULL,
  feature_id BIGINT,
  foreign key (feature_id) references feature_requirement(id)
);

CREATE TABLE file (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  last_execution TIMESTAMP NOT NULL
);