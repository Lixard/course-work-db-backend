ALTER TABLE appointments
    DROP CONSTRAINT appointments_fk0,
    DROP CONSTRAINT appointments_fk1;
ALTER TABLE appointments
    ADD CONSTRAINT appointments_fk0 FOREIGN KEY (patient_id) REFERENCES patients (patient_id)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    ADD CONSTRAINT appointments_fk1 FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
        On DELETE CASCADE ON UPDATE NO ACTION;


ALTER TABLE patient_diagnoses
    DROP CONSTRAINT patient_diagnoses_fk0,
    DROP CONSTRAINT patient_diagnoses_fk1;
ALTER TABLE patient_diagnoses
    ADD CONSTRAINT patient_diagnoses_fk0 FOREIGN KEY (appointment_id) REFERENCES appointments (appointment_id)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    ADD CONSTRAINT patient_diagnoses_fk1 FOREIGN KEY (diagnosis_id) REFERENCES diagnoses (diagnosis_id)
        ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE prescriptions_of_drugs
    DROP CONSTRAINT prescriptions_of_drugs_fk0,
    DROP CONSTRAINT prescriptions_of_drugs_fk1;
ALTER TABLE prescriptions_of_drugs
    ADD CONSTRAINT patient_diagnoses_fk0 FOREIGN KEY (appointment_id) REFERENCES appointments (appointment_id)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    ADD CONSTRAINT patient_diagnoses_fk1 FOREIGN KEY (drug_id) REFERENCES drugs (drug_id)
        ON DELETE CASCADE ON UPDATE NO ACTION;
