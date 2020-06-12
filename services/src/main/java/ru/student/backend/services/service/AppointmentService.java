package ru.student.backend.services.service;

import ru.student.backend.services.dto.AppointmentDto;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAppointments();

    List<ComplicatedAppointmentDto> getComplicatedAppointmentsEarlierThan(LocalDateTime date);

    List<ComplicatedAppointmentDto> getComplicatedAppointments();

    List<ComplicatedAppointmentDto> getComplicatedAppointmentsByPatient(int patientId);

    List<ComplicatedAppointmentDto> getComplicatedAppointmentsByDoctor(int doctorId);

    AppointmentDto findById(int id);

    List<AppointmentDto> getPatientAppointments(int patientId);

    AppointmentDto insert(AppointmentDto appointmentDto);

    AppointmentDto update(AppointmentDto appointmentDto);

    void delete(int id);
}
