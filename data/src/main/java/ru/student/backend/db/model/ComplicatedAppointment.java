package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplicatedAppointment {
    private int appointmentId;
    private int patientId;
    private String patientLastName;
    private int doctorId;
    private String doctorLastName;
    private String place;
    private String appointmentDate;
    private String symptoms;
}
