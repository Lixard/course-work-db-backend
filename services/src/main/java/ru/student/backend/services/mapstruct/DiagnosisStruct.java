package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.Diagnosis;
import ru.student.backend.services.dto.DiagnosisDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosisStruct {
    DiagnosisDto toDto(Diagnosis diagnosis);

    Diagnosis fromDto(DiagnosisDto diagnosisDto);

    List<DiagnosisDto> toDto(List<Diagnosis> diagnoses);

    List<Diagnosis> fromDto(List<DiagnosisDto> diagnosisDtos);
}
