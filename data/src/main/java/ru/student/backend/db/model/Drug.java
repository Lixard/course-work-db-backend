package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drug {
    private int drugId;
    private String name;
    private String methodOfTaking;
    private String dosage;
    private String descriptionOfAction;
    private String sideEffects;
}
