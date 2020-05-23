package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AppointmentDto {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String place;
    private Timestamp appointmentDate;
    private String symptoms;
}
