-- -------------------------------------------------------------------
-- Author:          Andrei Drynov
-- Created:         2022
-- Description:     SELECT, INSERT, UPDATE and DELETE queries
-- Version:         1.0.5
-- -------------------------------------------------------------------

-- show underage patients
SELECT first_name, last_name, birthdate FROM patient
WHERE YEAR(birthdate) > 2005;


-- -------------------------------------------------------------------
-- check whether the patient ID 1 has some unpaid bills
-- -------------------------------------------------------------------
SELECT COUNT(*) > 0 AS `OwesMoney` FROM bill WHERE patient_id = 1 and paid = 0;


-- -------------------------------------------------------------------
-- search for patients having any unpaid bills
-- -------------------------------------------------------------------
SELECT first_name, last_name FROM patient
WHERE patient_id IN (SELECT patient_id FROM bill WHERE paid = 0);


-- -------------------------------------------------------------------
-- list future appointments, starting from the next week
-- -------------------------------------------------------------------
SELECT * FROM appointment
WHERE appointment_date >= (NOW() + INTERVAL 7 - WEEKDAY(NOW()) DAY)
    AND status IN ('Scheduled', 'FollowUp');

-- -------------------------------------------------------------------
-- schedule a tomorrow appointment for patient John Abshire
-- -------------------------------------------------------------------
SELECT @tomorrow_afternoon := DATE_FORMAT(ADDDATE(NOW(), 1), '%Y-%m-%d 12:00:00');

INSERT INTO appointment (appointment_date, patient_id, doctor_id, status, by_type, notes)
VALUES (@tomorrow_afternoon, 6, 1, 'Scheduled', 'email', 'TOOD: add notes');

SELECT * FROM appointment ORDER BY appointment_id DESC LIMIT 1; -- check the result


-- -------------------------------------------------------------------
-- A patient cancels an appointment belatedly
-- -------------------------------------------------------------------
SET autocommit = OFF;

START TRANSACTION;

-- Kaela called to say that cannot attend the meeting
SET @patientId := 8;

-- the appointment is cancelled
UPDATE appointment
SET status  = 'Cancelled',
    by_type = 'phone',
    notes   = 'Kaela forgot about this appointment; charged the late cancellation fee'
WHERE appointment_id = 30
  AND patient_id = @patientId;

-- charged cancellation fee of 10 euro
INSERT INTO payment (patient_id, bill_id, payment_date, payment_amount, payment_type, cancellation_fee, notes)
VALUES (@patientId, NULL, NOW(), 10, 'credit card', TRUE, 'Patient cancelled the appointment too late');

COMMIT;

SET autocommit = ON;

-- -------------------------------------------------------------------
-- Return all unpaid treatments and late cancellations with patient Id
-- -------------------------------------------------------------------

SELECT patient_id, payment_amount AS amount, True as cancellation
FROM payment
WHERE cancellation_fee = 1

UNION ALL

SELECT patient_id, total_amount AS amount, False as cancellation
FROM bill
WHERE paid = 0;



-- -------------------------------------------------------------------
-- Remove very old appointment records
-- -------------------------------------------------------------------

DELETE FROM appointment WHERE YEAR(appointment_date) < 2012;
