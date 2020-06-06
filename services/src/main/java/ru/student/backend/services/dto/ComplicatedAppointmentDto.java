package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplicatedAppointmentDto {
    private int appointmentId;
    private SimpleEntity patient;
    private SimpleEntity doctor;
    private String place;
    private String appointmentDate;
    private String symptoms;

    @Getter
    @Setter
    public static class SimpleEntity {
        private int id;
        private String lastName;
    }
}


