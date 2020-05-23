package ru.student.backend.services.service;

import ru.student.backend.services.dto.PatientDiagnosesDto;

import java.util.List;

public interface PatientDiagnosesService {
    List<PatientDiagnosesDto> getAppointmentDiagnoses(int appointmentId);

    PatientDiagnosesDto findById(int appointmentId, int diagnosisId);

    PatientDiagnosesDto insert(PatientDiagnosesDto patientDiagnosesDto);

    void delete(int appointmentId, int diagnosisId);
}
