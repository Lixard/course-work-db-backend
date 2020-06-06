package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.student.backend.db.model.ComplicatedAppointment;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComplicatedAppointmentStruct {

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "patient.lastName", source = "patientLastName")
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "doctor.lastName", source = "doctorLastName")
    ComplicatedAppointmentDto toDto(ComplicatedAppointment complicatedAppointment);

    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "patientLastName", source = "patient.lastName")
    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "doctorLastName", source = "doctor.lastName")
    ComplicatedAppointment fromDto(ComplicatedAppointmentDto complicatedAppointmentDto);

    List<ComplicatedAppointmentDto> toDto(List<ComplicatedAppointment> complicatedAppointments);

    List<ComplicatedAppointment> fromDto(List<ComplicatedAppointmentDto> complicatedAppointmentDtos);

}
