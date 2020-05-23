package ru.student.backend.services.service;

import ru.student.backend.services.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getDoctors();

    DoctorDto findById(int id);

    DoctorDto insert(DoctorDto doctorDto);

    DoctorDto update(DoctorDto doctorDto);

    void delete(int id);
}
