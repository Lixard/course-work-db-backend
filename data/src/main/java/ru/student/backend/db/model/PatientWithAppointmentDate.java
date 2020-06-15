package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;
import ru.student.common.model.Sex;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PatientWithAppointmentDate {
    private int patientId;
    private String lastName;
    private String firstName;
    private String secondName;
    private Sex sex;
    private LocalDate birthday;
    private long policy;
    private int serialPassport;
    private int numberPassport;
    private LocalDateTime appointmentDate;
}
