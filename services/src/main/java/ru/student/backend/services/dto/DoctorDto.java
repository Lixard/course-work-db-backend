package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
    private int doctorId;
    private String lastName;
    private String firstName;
    private String secondName;
}
