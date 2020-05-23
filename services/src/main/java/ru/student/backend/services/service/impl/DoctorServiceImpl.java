package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.DoctorMapper;
import ru.student.backend.services.dto.DoctorDto;
import ru.student.backend.services.mapstruct.DoctorStruct;
import ru.student.backend.services.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorStruct doctorStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public DoctorServiceImpl(DoctorMapper doctorMapper,
                             DoctorStruct doctorStruct) {
        this.doctorMapper = doctorMapper;
        this.doctorStruct = doctorStruct;
    }

    @Override
    public List<DoctorDto> getDoctors() {
        return doctorStruct.toDto(doctorMapper.getDoctors());
    }

    @Override
    public DoctorDto findById(int id) {
        return doctorStruct.toDto(doctorMapper.findById(id));
    }

    @Override
    public DoctorDto insert(DoctorDto doctorDto) {
        doctorMapper.insert(doctorStruct.fromDto(doctorDto));
        return doctorDto;
    }

    @Override
    public DoctorDto update(DoctorDto doctorDto) {
        doctorMapper.update(doctorStruct.fromDto(doctorDto));
        return doctorDto;
    }

    @Override
    public void delete(int id) {
        doctorMapper.delete(id);
    }
}
