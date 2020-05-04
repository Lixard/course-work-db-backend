package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDiagnoses {
    private int appointmentId;
    private int diagnosisId;
}
