-- Create DataBase
CREATE SCHEMA `db`;

-- Select Schema
USE db;

-- Create Table user
CREATE TABLE user
(
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    login        VARCHAR(255) NOT NULL,
    `password`   VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    gender       VARCHAR(255),
    email        VARCHAR(255),
    phone_number VARCHAR(255),
    birthdate    DATETIME,
    description  VARCHAR(5000),
    PRIMARY KEY (id)
);

-- Create Table role
CREATE TABLE role
(
    id   BIGINT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table role_to_user
CREATE TABLE role_to_user
(
    id      BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_ROLE_USER__USER FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT FK_ROLE_USER__ROLE FOREIGN KEY (role_id) REFERENCES role (id)
);

-- Create Table permission
CREATE TABLE permission
(
    id   BIGINT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table permission_to_role
CREATE TABLE permission_to_role
(
    id            BIGINT NOT NULL AUTO_INCREMENT,
    permission_id BIGINT NOT NULL,
    role_id       BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_PERMISSION_ROLE__PERMISSION FOREIGN KEY (permission_id) REFERENCES permission (id),
    CONSTRAINT FK_PERMISSION_ROLE__ROLE FOREIGN KEY (role_id) REFERENCES role (id)
);

-- Create Table change_password
CREATE TABLE change_password
(
    id       BIGINT          NOT NULL AUTO_INCREMENT,
    user_id  BIGINT          NOT NULL,
    hashcode VARCHAR(255) NOT NULL,
    date     DATETIME     NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table customer
CREATE TABLE customer
(
    id           BIGINT          NOT NULL AUTO_INCREMENT,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    gender       VARCHAR(255),
    email        VARCHAR(255),
    phone_number INT          NOT NULL,
    birthdate    DATE,
    description  VARCHAR(5000),
    PRIMARY KEY (id)
);

-- Create Table car
CREATE TABLE car
(
    id            BIGINT          NOT NULL AUTO_INCREMENT,
    customer_id   BIGINT          NOT NULL,
    plate         VARCHAR(255) NOT NULL,
    plate_country VARCHAR(255) NOT NULL,
    vin           VARCHAR(255),
    brand         VARCHAR(255) NOT NULL,
    model         VARCHAR(255) NOT NULL,
    model_code    VARCHAR(255) NOT NULL,
    fuel_type     VARCHAR(255) NOT NULL,
    year          DATE         NOT NULL,
    description   VARCHAR(5000),
    PRIMARY KEY (id),
    CONSTRAINT FK_CUSTOMER__CAR FOREIGN KEY (customer_id) REFERENCES customer (id)
);

-- Create Table repair
CREATE TABLE repair
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    car_id         BIGINT      NOT NULL,
    mileage        INT      NOT NULL,
    admission_date DATETIME NOT NULL,
    estimated_date DATETIME,
    description    VARCHAR(5000),
    PRIMARY KEY (id),
    CONSTRAINT FK_CAR__REPAIR FOREIGN KEY (car_id) REFERENCES car (id)
);

-- Create Table service
CREATE TABLE service
(
    id               BIGINT            NOT NULL AUTO_INCREMENT,
    name             VARCHAR(255)   NOT NULL,
    recommended_cost DECIMAL(10, 2) NOT NULL,
    min_cost         DECIMAL(10, 2),
    max_cost         DECIMAL(10, 2),
    description      VARCHAR(5000),
    PRIMARY KEY (id)
);

-- Create Table service_to_repair
CREATE TABLE service_to_repair
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    repair_id  BIGINT NOT NULL,
    service_id BIGINT NOT NULL,
    cost       DECIMAL(10, 2),
    PRIMARY KEY (id),
    CONSTRAINT FK_SERVICE_REPAIR__REPAIR FOREIGN KEY (repair_id) REFERENCES repair (id),
    CONSTRAINT FK_SERVICE_REPAIR__SERVICE FOREIGN KEY (service_id) REFERENCES service (id)
);

-- Create Table parts_to_repair
CREATE TABLE part
(
    id          BIGINT           NOT NULL AUTO_INCREMENT,
    repair_id   BIGINT           NOT NULL,
    name        VARCHAR(5000) NOT NULL,
    cost        DECIMAL(10, 2),
    description VARCHAR(5000),
    part_code   VARCHAR(5000),
    PRIMARY KEY (id),
    CONSTRAINT FK_PART__REPAIR FOREIGN KEY (repair_id) REFERENCES repair (id)
);
