package ru.student.backend.services.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDto {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String place;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime appointmentDate;
    private String symptoms;
}
