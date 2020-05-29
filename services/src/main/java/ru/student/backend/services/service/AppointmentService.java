package ru.student.backend.services.service;

import ru.student.backend.services.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAppointments();

    AppointmentDto findById(int id);

    List<AppointmentDto> getPatientAppointments(int patientId);

    AppointmentDto insert(AppointmentDto appointmentDto);

    AppointmentDto update(AppointmentDto appointmentDto);

    void delete(int id);
}
