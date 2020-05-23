package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.PatientDiagnoses;
import ru.student.backend.services.dto.PatientDiagnosesDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientDiagnosesStruct {
    PatientDiagnosesDto toDto(PatientDiagnoses patientDiagnoses);

    PatientDiagnoses fromDto(PatientDiagnosesDto patientDiagnosesDto);

    List<PatientDiagnosesDto> toDto(List<PatientDiagnoses> patientDiagnoses);

    List<PatientDiagnoses> fromDto(List<PatientDiagnosesDto> patientDiagnosesDtos);
}
