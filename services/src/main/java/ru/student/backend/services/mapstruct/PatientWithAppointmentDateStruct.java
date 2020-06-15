package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.PatientWithAppointmentDate;
import ru.student.backend.services.dto.PatientWithAppointmentDateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientWithAppointmentDateStruct {
    PatientWithAppointmentDateDto toDto(PatientWithAppointmentDate patientWithAppointmentDate);

    PatientWithAppointmentDate fromDto(PatientWithAppointmentDateDto patientWithAppointmentDateDto);

    List<PatientWithAppointmentDateDto> toDto(List<PatientWithAppointmentDate> patientWithAppointmentDateList);

    List<PatientWithAppointmentDate> fromDto(List<PatientWithAppointmentDateDto> patientWithAppointmentDateDtoList);
}
