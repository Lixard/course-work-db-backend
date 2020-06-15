package ru.student.backend.services.service;

import ru.student.backend.services.dto.PatientDto;
import ru.student.backend.services.dto.PatientWithAppointmentDateDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientService {
    List<PatientDto> getPatients();

    List<PatientWithAppointmentDateDto> getPatientsPerDoctorWithPeriod(int doctorId, LocalDateTime dateStart, LocalDateTime dateEnd);

    PatientDto findById(int id);

    PatientDto insert(PatientDto patientDto);

    PatientDto update(PatientDto patientDto);

    void delete(int id);
}
