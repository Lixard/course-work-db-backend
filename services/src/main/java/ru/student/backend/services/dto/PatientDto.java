package ru.student.backend.services.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import ru.student.common.model.Sex;

import java.time.LocalDate;

@Getter
@Setter
public class PatientDto {
    private int patientId;
    private String lastName;
    private String firstName;
    private String secondName;
    private Sex sex;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    private long policy;
    private int serialPassport;
    private int numberPassport;
}
