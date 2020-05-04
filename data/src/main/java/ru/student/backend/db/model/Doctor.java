package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {
    private int doctorId;
    private int userId;
    private String lastName;
    private String firstName;
    private String secondName;
}
