package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.Appointment;
import ru.student.backend.services.dto.AppointmentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentStruct {
    AppointmentDto toDto(Appointment appointment);

    Appointment fromDto(AppointmentDto appointmentDto);

    List<AppointmentDto> toDto(List<Appointment> appointments);

    List<Appointment> fromDto(List<AppointmentDto> appointmentDtos);
}
