package ru.student.backend.services.service;

import ru.student.backend.services.dto.DiagnosisDto;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDto> getDiagnoses();

    DiagnosisDto findById(int id);

    DiagnosisDto insert(DiagnosisDto diagnosisDto);

    DiagnosisDto update(DiagnosisDto diagnosisDto);

    void delete(int id);
}
