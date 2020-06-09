package ru.student.backend.services.service;

import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.dto.PatientDiagnosesDto;

import java.util.List;

public interface PatientDiagnosesService {
    List<DiagnosisDto> getAppointmentDiagnoses(int appointmentId);

    PatientDiagnosesDto findById(int appointmentId, int diagnosisId);

    PatientDiagnosesDto insert(PatientDiagnosesDto patientDiagnosesDto);

    void delete(int appointmentId, int diagnosisId);
}
