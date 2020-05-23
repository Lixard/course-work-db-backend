package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.student.common.model.Sex;

import java.sql.Date;

@Getter
@Setter
public class PatientDto {
    private int patientId;
    private String lastName;
    private String firstName;
    private String secondName;
    private Sex sex;
    private Date birthday;
    private long policy;
    private int serialPassport;
    private int numberPassport;
}
