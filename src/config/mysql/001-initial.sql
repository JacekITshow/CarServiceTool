-- Create DataBase
CREATE SCHEMA `db`;

-- Create Table User
CREATE TABLE User
(
    id           INT          NOT NULL AUTO_INCREMENT,
    login        VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255),
    surname      VARCHAR(255),
    gender       VARCHAR(255),
    email        VARCHAR(255),
    phone_number VARCHAR(255),
    birthdate    DATETIME,
    description  VARCHAR(5000),
    PRIMARY KEY (id)
);

-- Create Table Role
CREATE TABLE Role
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table RoleToUser
CREATE TABLE RoleToUser
(
    id      INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (role_id) REFERENCES Role (id)
);

-- Create Table Permission
CREATE TABLE Permission
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table PermissionToRole
CREATE TABLE PermissionToRole
(
    id            INT NOT NULL AUTO_INCREMENT,
    permission_id INT NOT NULL,
    role_id       INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (permission_id) REFERENCES Permission (id),
    FOREIGN KEY (role_id) REFERENCES Role (id)
);

-- Create Table ChangePassword
CREATE TABLE ChangePassword
(
    id       INT          NOT NULL AUTO_INCREMENT,
    user_id  INT          NOT NULL,
    hashcode VARCHAR(255) NOT NULL,
    date     DATETIME     NOT NULL,
    PRIMARY KEY (id)
);

-- Create Table Customer
CREATE TABLE Customer
(
    id           INT          NOT NULL AUTO_INCREMENT,
    first_name   VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    gender       VARCHAR(255),
    email        VARCHAR(255),
    phone_number INT          NOT NULL,
    birthdate    DATE,
    description  VARCHAR(5000),
    PRIMARY KEY (id)
);

-- Create Table Car
CREATE TABLE Car
(
    id            INT          NOT NULL AUTO_INCREMENT,
    customer_id   INT          NOT NULL,
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
    FOREIGN KEY (customer_id) REFERENCES Customer (id)
);

-- Create Table Repair
CREATE TABLE Repair
(
    id             INT      NOT NULL AUTO_INCREMENT,
    car_id         INT      NOT NULL,
    admission_date DATETIME NOT NULL,
    estimated_date DATETIME,
    description    VARCHAR(5000),
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES Car (id)
);

-- Create Table Service
CREATE TABLE Service
(
    id               INT          NOT NULL AUTO_INCREMENT,
    name             VARCHAR(255) NOT NULL,
    recommended_cost INT          NOT NULL,
    min_cost DOUBLE NOT NULL,
    max_cost         INT          NOT NULL,
    description      VARCHAR(5000),
    PRIMARY KEY (id),
);

-- Create Table ServiceToRepair
CREATE TABLE ServiceToRepair
(
    id         INT NOT NULL AUTO_INCREMENT,
    repair_id  INT NOT NULL,
    service_id INT NOT NULL,
    cost       DECIMAL(2, 2),
    PRIMARY KEY (id),
    FOREIGN KEY (repair_id) REFERENCES Repair (id),
    FOREIGN KEY (service_id) REFERENCES Service (id)
);

-- Create Table ServiceToRepair
CREATE TABLE PartsToRepair
(
    id          INT NOT NULL AUTO_INCREMENT,
    repair_id   INT NOT NULL,
    name        INT NOT NULL,
    cost        DECIMAL(2, 2),
    description VARCHAR(5000),
    part_code   VARCHAR(5000),
    PRIMARY KEY (id),
    FOREIGN KEY (repair_id) REFERENCES Repair (id)
);
