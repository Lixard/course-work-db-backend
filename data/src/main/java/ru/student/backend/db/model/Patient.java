package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Patient {
    private int patientId;
    private String lastName;
    private String firstName;
    private String secondName;
    //TODO в будущем поменять на Sex enum
    private String sex;
    private Date birthday;
    private long policy;
    private int serialPassport;
    private int numberPassport;
}
