package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.AppointmentMapper;
import ru.student.backend.db.model.Appointment;
import ru.student.backend.services.dto.AppointmentDto;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.mapstruct.AppointmentStruct;
import ru.student.backend.services.mapstruct.ComplicatedAppointmentStruct;
import ru.student.backend.services.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentStruct appointmentStruct;
    private final ComplicatedAppointmentStruct complicatedAppointmentStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public AppointmentServiceImpl(AppointmentMapper appointmentMapper,
                                  AppointmentStruct appointmentStruct,
                                  ComplicatedAppointmentStruct complicatedAppointmentStruct) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentStruct = appointmentStruct;
        this.complicatedAppointmentStruct = complicatedAppointmentStruct;
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        return appointmentStruct.toDto(appointmentMapper.getAppointments());
    }

    @Override
    public List<ComplicatedAppointmentDto> getComplicatedAppointmentsEarlierThan(LocalDateTime date) {
        return complicatedAppointmentStruct.toDto(appointmentMapper.getComplicatedAppointmentsEarlierThanDate(date));
    }

    @Override
    public List<ComplicatedAppointmentDto> getComplicatedAppointments() {
        return complicatedAppointmentStruct.toDto(appointmentMapper.getComplicatedAppointments());
    }

    @Override
    public List<ComplicatedAppointmentDto> getComplicatedAppointmentsByPatient(int patientId) {
        return complicatedAppointmentStruct.toDto(appointmentMapper.getComplicatedAppointmentsByPatient(patientId));
    }

    @Override
    public List<ComplicatedAppointmentDto> getComplicatedAppointmentsByDoctor(int doctorId) {
        return complicatedAppointmentStruct.toDto(appointmentMapper.getComplicatedAppointmentsByDoctor(doctorId));
    }

    @Override
    public AppointmentDto findById(int id) {
        return appointmentStruct.toDto(appointmentMapper.findById(id));
    }

    @Override
    public List<AppointmentDto> getPatientAppointments(int patientId) {
        return appointmentStruct.toDto(appointmentMapper.getPatientAppointments(patientId));
    }

    @Override
    public AppointmentDto insert(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentStruct.fromDto(appointmentDto);
        appointmentMapper.insert(appointment);
        return appointmentStruct.toDto(appointment);
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
