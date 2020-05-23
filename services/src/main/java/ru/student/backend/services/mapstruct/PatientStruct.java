package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.Patient;
import ru.student.backend.services.dto.PatientDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PatientStruct {
    PatientDto toDto(Patient patient);

    Patient fromDto(PatientDto patientDto);

    List<PatientDto> toDto(List<Patient> patients);

    List<Patient> fromDto(List<PatientDto> patientDtos);
}
