package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionOfDrugs {
    private int appointmentId;
    private int drugId;
}
