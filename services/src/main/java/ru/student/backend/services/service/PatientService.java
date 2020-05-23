package ru.student.backend.services.service;

import ru.student.backend.services.dto.PatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> getPatients();

    PatientDto findById(int id);

    PatientDto insert(PatientDto patientDto);

    PatientDto update(PatientDto patientDto);

    void delete(int id);
}
