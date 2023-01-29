-- -------------------------------------------------------------------
-- Author:          Andrei Drynov
-- Created:         2023
-- Description:     Insert dummy data into the Car Dealership database
-- Database Name:   cardealer
-- Version:         1
-- -------------------------------------------------------------------
-- This script is run by Bitnami MySQL container on the first start
-- -------------------------------------------------------------------

INSERT INTO department(name)
VALUES ('Accounting'),
       ('Sales Force'),
       ('Finance'),
       ('Service'),
       ('HR');

INSERT INTO employee (employee_no, first_name, last_name, phone, manager_id, department_id, salary, hire_date)
VALUES ('JD201', 'Joe', 'Doe', 1234567890, NULL, 2, 45000, STR_TO_DATE('01-01-2023', '%d-%m-%Y')),
       ('JS203', 'James', 'Smith', 123513241, 1, 2, 29350, STR_TO_DATE('15-01-2023', '%d-%m-%Y')),
       ('WS401', 'William', 'Sheakspear', 532153201, NULL, 4, 42500, STR_TO_DATE('02-01-2023', '%d-%m-%Y')),
       ('MS401', 'Michael', 'Smith', NULL, 4, 4, 36500, STR_TO_DATE('08-01-2023', '%d-%m-%Y'));


-- customer data generated using https://filldb.info/       
INSERT INTO customer (id, first_name, last_name, email, phone)
VALUES (1, 'Andrei', 'Drynov', 'info@adrynov.com', '(06796) 417027'),
       (2, 'Lucinda', 'Harris', 'friedrich94@example.com', '+44(0)4955635139'),
       (3, 'Isac', 'Runte', 'gerardo.emard@example.com', '+44(0)1492 100636'),
       (4, 'Ashtyn', 'Brown', 'emmanuelle71@example.org', '+44(0)474141977'),
       (5, 'Dejon', 'Gaylord', 'mtoy@example.com', '00707 05433'),
       (6, 'Filomena', 'Cremin', 'konopelski.alva@example.org', '0934500256'),
       (7, 'Ruthe', 'Stokes', 'oschamberger@example.net', '03306675845'),
       (8, 'Pamela', 'Kulas', 'lind.wilburn@example.com', '(03145) 179040'),
       (9, 'Dock', 'Rath', 'csimonis@example.org', '06585 26977');


INSERT INTO car (make, model, price, status, customer_id, employee_id)
VALUES ('Audi', 'A6', 14000, 'delivered', 1, 1),
    ('VW', 'Beetle', 29210, 'pending', 7, 2)
;
