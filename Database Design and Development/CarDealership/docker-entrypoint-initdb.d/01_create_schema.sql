-- -------------------------------------------------------------------
-- Author:          Andrei Drynov
-- Created:         2023
-- Description:     Create tables for Car Dealership database
-- Database Name:   cardealer
-- Version:         1.1
-- -------------------------------------------------------------------
-- This script is run by Bitnami MySQL container on the first start
-- -------------------------------------------------------------------


CREATE TABLE IF NOT EXISTS car
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    make        VARCHAR(50)                                                     NOT NULL,
    model       VARCHAR(50)                                                     NOT NULL,
    price       DECIMAL(10, 2)                                                  NOT NULL,
    status      ENUM ('ordered', 'pending', 'ready', 'dispatched', 'delivered') NOT NULL,
    customer_id INT UNSIGNED                                                    NOT NULL,
    employee_id INT UNSIGNED                                                    NOT NULL
);

CREATE TABLE IF NOT EXISTS customer
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(100) NOT NULL,
    phone      VARCHAR(25)  NULL
);

CREATE TABLE IF NOT EXISTS department
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    CONSTRAINT uc_department UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS employee
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    employee_no   CHAR(5)     NOT NULL,
    first_name    VARCHAR(35) NOT NULL,
    last_name     VARCHAR(35) NOT NULL,
    phone         VARCHAR(11) NULL,
    manager_id    INT         NULL,
    department_id INT         NOT NULL,
    salary        INT         NOT NULL,
    hire_date     DATETIME    NOT NULL,
    CONSTRAINT uq_employee UNIQUE (employee_no),
    CONSTRAINT employee_ibfk_1 FOREIGN KEY (manager_id) REFERENCES employee (id),
    CONSTRAINT employee_ibfk_2 FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE INDEX department_id ON employee (department_id);
CREATE INDEX manager_id ON employee (manager_id);

