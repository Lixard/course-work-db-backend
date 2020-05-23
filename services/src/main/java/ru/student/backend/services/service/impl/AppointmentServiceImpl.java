package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.AppointmentMapper;
import ru.student.backend.services.dto.AppointmentDto;
import ru.student.backend.services.mapstruct.AppointmentStruct;
import ru.student.backend.services.service.AppointmentService;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentStruct appointmentStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public AppointmentServiceImpl(AppointmentMapper appointmentMapper,
                                  AppointmentStruct appointmentStruct) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentStruct = appointmentStruct;
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        return appointmentStruct.toDto(appointmentMapper.getAppointments());
    }

    @Override
    public AppointmentDto findById(int id) {
        return appointmentStruct.toDto(appointmentMapper.findById(id));
    }

    @Override
    public AppointmentDto insert(AppointmentDto appointmentDto) {
        appointmentMapper.insert(appointmentStruct.fromDto(appointmentDto));
        return appointmentDto;
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        appointmentMapper.update(appointmentStruct.fromDto(appointmentDto));
        return appointmentDto;
    }

    @Override
    public void delete(int id) {
        appointmentMapper.delete(id);
    }
}
