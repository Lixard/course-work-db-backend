package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.Doctor;
import ru.student.backend.services.dto.DoctorDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorStruct {
    DoctorDto toDto(Doctor doctor);

    Doctor fromDto(DoctorDto DoctorDto);

    List<DoctorDto> toDto(List<Doctor> doctors);

    List<Doctor> fromDto(List<DoctorDto> doctorDtos);
}
