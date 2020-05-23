package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDiagnosesDto {
    private int appointmentId;
    private int diagnosisId;
}
