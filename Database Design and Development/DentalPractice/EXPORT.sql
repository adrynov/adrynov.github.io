-- -------------------------------------------------------------------
-- Author:          Andrei Drynov
-- Created:         2022
-- Description:     Creates the project database and dumps test data
-- Version:         1.1.4
-- -------------------------------------------------------------------
-- Database Name:   G00411287
-- MySQL version:   8.0.28
-- phpMyAdmin:      5.1.3
-- -------------------------------------------------------------------

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;
SET time_zone = "+00:00";


--
-- Create database called `G00411287`
--
CREATE DATABASE IF NOT EXISTS `G00411287` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `G00411287`;


-- --------------------------------------------------------
-- Table Creation
-- --------------------------------------------------------

DROP TABLE IF EXISTS `payment`;
DROP TABLE IF EXISTS `bill`;
DROP TABLE IF EXISTS `treatment`;
DROP TABLE IF EXISTS `appointment`;
DROP TABLE IF EXISTS `doctor`;
DROP TABLE IF EXISTS `patient`;
DROP TABLE IF EXISTS `address`;


CREATE TABLE `address`
(
    address_id    INT AUTO_INCREMENT PRIMARY KEY,
    business_name VARCHAR(50)                   NULL,
    address_line1 VARCHAR(50)                   NOT NULL,
    address_line2 VARCHAR(50)                   NULL,
    city          VARCHAR(50)                   NOT NULL,
    county        VARCHAR(25)                   NULL,
    eircode       VARCHAR(10) DEFAULT 'XXX XXX' NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `doctor`
(
    doctor_id    INT AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(50)          NOT NULL,
    last_name    VARCHAR(50)          NOT NULL,
    phone_number VARCHAR(100)         NULL,
    type         VARCHAR(50)          NULL,
    internal     TINYINT(1) DEFAULT 1 NOT NULL,
    address_id   INT                  NULL,
    CONSTRAINT fk_doctor_address FOREIGN KEY (address_id) REFERENCES address (address_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `patient`
(
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50)               NOT NULL,
    last_name  VARCHAR(50)               NOT NULL,
    birthdate  DATE                      NULL,
    gender     CHAR                      NULL,
    address_id INT                       NULL,
    phone      VARCHAR(50)               NOT NULL,
    email      VARCHAR(100)              NULL,
    notes      VARCHAR(500) CHARSET utf8 NULL,
    CONSTRAINT fk_patient_address FOREIGN KEY (address_id) REFERENCES address (address_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `appointment`
(
    appointment_id   INT AUTO_INCREMENT PRIMARY KEY,
    appointment_date DATETIME     NOT NULL,
    doctor_id        INT          NULL,
    patient_id       INT          NOT NULL,
    status           VARCHAR(20)  NULL,
    by_type          VARCHAR(10)  NULL,
    notes            VARCHAR(500) NULL,
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `treatment`
(
    treatment_id   INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT            NULL,
    treatment_date DATETIME       NOT NULL,
    doctor_id      INT            NOT NULL,
    fees           DECIMAL(10, 2) NOT NULL,
    discount       DECIMAL(10, 2) NULL,
    description    VARCHAR(500)   NULL,
    CONSTRAINT fk_treatment_appointment FOREIGN KEY (appointment_id) REFERENCES appointment (appointment_id),
    CONSTRAINT fk_treatment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `bill`
(
    bill_id        INT AUTO_INCREMENT   PRIMARY KEY,
    treatment_id   INT                         NOT NULL,
    patient_id     INT                         NOT NULL,
    bill_number    VARCHAR(50)                 NOT NULL,
    bill_date      DATETIME                    NOT NULL,
    total_payments INT            DEFAULT 0    NOT NULL,
    total_amount   DECIMAL(10, 2) DEFAULT 0.00 NOT NULL,
    paid           TINYINT(1)     DEFAULT 0    NOT NULL,
    CONSTRAINT fk_bill_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id),
    CONSTRAINT fk_bill_treatment FOREIGN KEY (treatment_id) REFERENCES treatment (treatment_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `payment`
(
    payment_id       INT AUTO_INCREMENT PRIMARY KEY,
    patient_id       INT                  NOT NULL,
    bill_id          INT                  NULL,
    payment_date     DATETIME             NOT NULL,
    payment_amount   DECIMAL(10, 2)       NOT NULL,
    payment_type     VARCHAR(20)          NULL,
    cancellation_fee TINYINT(1) DEFAULT 0 NULL,
    notes            VARCHAR(500)         NULL,
    CONSTRAINT fk_payment_bill FOREIGN KEY (bill_id) REFERENCES bill (bill_id),
    CONSTRAINT pk_payment_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;



-- --------------------------------------------------------
-- Populate the database with test data
-- --------------------------------------------------------

INSERT INTO `address` (address_id, business_name, address_line1, address_line2, city, county, eircode)
VALUES (1, NULL, 'Dillons Cross', 'The Glen', 'Cork', 'Cork', 'XXX XXX'),
       (2, NULL, '782 Kareem Passage', 'Suite 442', 'West Jasper', 'Antrim', 'XXX XXX'),
       (3, NULL, '369 Harris Inlet', 'Apt. 9', 'Kinsale', 'Cork', 'XXX XXX'),
       (4, NULL, '2168 Ullrich Flats', 'Apt. 442', 'Johnsonstad', 'Clare', 'XXX XXX'),
       (5, NULL, '4238 Keanu Square Suite 668', 'Suite 895', 'Killarney', 'Kerry', 'XXX XXX'),
       (6, NULL, '498 Summer Knolls Suite 803', 'Suite 244', 'North Letitia', 'Offaly', 'XXX XXX'),
       (7, NULL, '13536 Aditya Prairie', 'Apt. 247', 'Dibbertport', 'Louth', 'XXX XXX'),
       (8, NULL, '23282 Justyn Park', 'Apt. 533', 'Limerick', 'Limerick', 'XXX XXX'),
       (9, NULL, '591 Jada Inlet Suite 754', 'Suite 765', 'Altheaview', 'Wicklow', 'XXX XXX'),
       (10, NULL, '7490 Lebsack Light', 'Suite 320', 'Dublin', 'Dublin', 'XXX XXX'),
       (11, 'Cork University Hospital', 'CUH, Wilton', 'Cork', 'Cork', 'Cork', NULL),
       (12, 'Cork Dental Clinic', 'Old Quarter', 'Old Fort Road', 'Ballincollig', 'Cork', NULL),
       (13, NULL, '12 Barrimore Close', NULL, 'Baltimore', 'Cork', 'XXX XXX'),
       (14, 'Nostra Dental', 'Firview', 'Curraheen Road', 'Bishopstown', 'Cork', 'XXX XXX'),
       (15, NULL, 'Moon Base', 'The Dark Side', 'NoNaMe', 'Space', 'XXX XXX');


INSERT INTO `doctor` (doctor_id, first_name, last_name, phone_number, `type`, internal, address_id)
VALUES (1, 'Mary', 'Mulcahy', '0035321123456', 'Generalist', 1, NULL),
       (2, 'John', 'Murphy', '021 4920500', 'Endodontist', 0, 11),
       (3, 'Murat', 'Bzheshovsky', '0035311234567', 'Missing Teeth', 0, 12),
       (4, 'Anthony', 'OConnely', NULL, 'Periodontist', 1, 14);


INSERT INTO `patient` (patient_id, first_name, last_name, birthdate, gender, address_id, phone, email, notes)
VALUES (1, 'Andrei', 'Drynov', '1974-02-26', 'M', 1, '086 1234567', 'none@really.com', 'No allergies'),
       (2, 'Owen', 'Murphy', '2012-04-04', 'M', 4, '087 1234567', NULL, 'No past treatments'),
       (3, 'Zola', 'Johns', '1985-02-25', 'F', 10, '086 1234567', 'norval74@example.org',
        'Pariatur et aliquid labore quo vel quia. Qui quo laborum ut dolorem voluptatem qui.'),
       (4, 'Shanon', 'Luettgen', '1980-02-08', 'F', 2, '085 1234567', 'phyllis.kovacek@example.com',
        'Quisquam et et ratione velit. Dicta adipisci quos voluptatem modi quis numquam eum. '),
       (5, 'Armani', 'McKenzie', '1986-09-27', 'M', 7, '089 1234567', 'dschmidt@example.org',
        'Perspiciatis qui distinctio eius ullam et iusto nostrum. Asperiores et nobis architecto neque dolores.'),
       (6, 'John', 'Abshire', '2009-12-22', 'M', 5, '086 1234567', 'harley11@example.org',
        'Ut id omnis voluptates accusamus eum. Amet aut voluptatem veniam ex corrupti.'),
       (7, 'Meta', 'Connoly', '1984-03-03', NULL, NULL, '021 1234567', 'gmills@example.com',
        'Beatae qui nobis eum sed molestiae at nobis.'),
       (8, 'Kaela', 'Krajcik', '1997-12-05', 'F', 3, '01 1234567', NULL,
        'Porro doloribus itaque vel autem. Modi quisquam dolor eum.'),
       (9, 'Desmond', 'Rice', '1976-03-12', 'M', 10, '086 1234567', 'eli.spinka@example.com',
        'Non minima aut fuga sint. Saepe aut eius officia occaecati vel maxime laborum ab.'),
       (10, 'Katrina', 'Ruecker', '1987-02-20', NULL, 9, '086 1234567', 'little.soledad@example.org',
        'Amet numquam esse nesciunt non et sunt.');

INSERT INTO `appointment` (appointment_id, appointment_date, doctor_id, patient_id, status, by_type, notes)
VALUES (1, '2022-01-17 09:00:00', 1, 1, 'Completed', 'dropin', 'The bill fully paid for; patient happy'),
       (3, '2022-03-10 12:00:00', 1, 1, 'Completed', 'dropin', NULL),
       (4, '2022-03-10 10:00:00', 1, 4, 'Completed', 'phone', NULL),
       (5, '2011-11-27 07:57:19', NULL, 5, NULL, NULL, 'Archived for records'),
       (6, '2022-03-28 20:35:13', 1, 1, 'Rescheduled', 'phone', 'Patient could not make it due to family reasons'),
       (11, '2022-04-21 15:00:00', 4, 9, 'Specialist', 'referral', 'Mary referred this patient to a Periodontist'),
       (12, '2022-04-01 08:56:33', NULL, 2, 'Cancelled ', 'post', NULL),
       (13, '2022-04-01 11:30:00', 1, 3, 'Completed', 'post', NULL),
       (14, '2022-04-29 19:00:00', 4, 4, 'Scheduled', 'phone', NULL),
       (15, '2022-04-02 13:30:00', 1, 1, 'Completed', 'email', NULL),
       (17, '2005-04-05 16:54:54', NULL, 7, NULL, NULL, 'No Show Up'),
       (18, '2022-05-13 12:30:50', 1, 2, 'FollowUp', 'email', 'Follow Up treatment is required as per patients card'),
       (28, '2022-04-13 14:15:00', 3, 5, 'Completed', 'phone', 'Referred to Dr. Bzheshovsky'),
       (31, '2022-04-21 12:00:00', 1, 6, 'Scheduled', 'phone', 'Patient complains about severe toothache and fever');


INSERT INTO `treatment` (treatment_id, appointment_id, treatment_date, doctor_id, fees, discount, description)
VALUES (1, 1, '2022-01-17 09:30:00', 1, 65.00, NULL, 'Doctor scribbles something that nobody can understand'),
       (2, 4, '2022-03-10 10:00:00', 1, 127.00, 27.00, NULL),
       (3, 3, '2022-03-10 12:00:00', 4, 132.00, 0.00, 'Soluta iure nihil hic dolor aut occaecati.'),
       (4, 11, '2005-05-13 20:25:00', 2, 45.00, 45.00, 'Referred to CUH'),
       (5, 13, '2022-04-01 11:42:00', 1, 80.00, 0.00, 'Molestias qui vitae deleniti quia.'),
       (7, 15, '2022-04-02 13:00:00', 1, 555.00, 5.00, 'Dolorem assumenda iusto magnam sequi'),
       (8, 1, '1984-11-22 08:30:06', 3, 176.05, 76.50, 'Placeat sed iusto magnam ut'),
       (11, 28, '2022-04-13 14:56:00', 1, 60.00, 20.00, 'Referred to a Periodontist'),
       (12, 31, '2022-04-22 10:28:20', 1, 220.00, NULL, NULL);


INSERT INTO `bill` (bill_id, treatment_id, patient_id, bill_number, bill_date, total_payments, total_amount, paid)
VALUES  (1, 1, 1, 'Kd7mn37v', '2022-01-18 09:00:00', 2, 65.00, 1),
        (2, 7, 1, 'D78j32hy', '2021-12-25 09:00:00', 1, 550.00, 0),
        (3, 3, 2, 'KJ624xdD', '2022-03-11 09:00:00', 3, 132.00, 1),
        (4, 11, 5, 'Rmuyd21S', '2022-04-14 09:00:00', 1, 60.00, 1),
        (5, 12, 1, 'Ks7j2020', '2022-04-23 09:00:00', 0, 0.00, 0);


INSERT INTO `payment` (payment_id, patient_id, bill_id, payment_date, payment_amount, payment_type, cancellation_fee, notes)
VALUES  (7, 1, 1, '2022-01-18 09:00:00', 50.00, 'credit card', 0, NULL),
        (8, 1, 1, '2022-01-19 09:00:00', 15.00, 'cash', 0, 'Patient paid 50 euro in cash'),
        (10, 1, 2, '2022-01-05 13:00:00', 50.00, 'cheque', 0, NULL),
        (11, 2, 3, '2022-03-12 16:05:45', 80.00, 'credit card', 0, NULL),
        (12, 2, 3, '2022-03-13 10:23:00', 33.00, 'credit card', 0, 'Paid the remainder by credit card, and 10 euro in cash'),
        (13, 2, 3, '2022-03-13 10:25:00', 10.00, 'cash', 0, NULL),
        (14, 5, 4, '2022-04-14 18:32:00', 40.00, 'credit card', 0, NULL);


COMMIT;

