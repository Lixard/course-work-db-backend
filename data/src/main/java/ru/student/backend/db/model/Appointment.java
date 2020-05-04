package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String place;
    private Timestamp appointmentDate;
    private String symptoms;
}
