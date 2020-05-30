package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String place;
    private LocalDateTime appointmentDate;
    private String symptoms;
}
