package ru.student.backend.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrugDto {
    private int drugId;
    private String name;
    private String methodOfTaking;
    private String dosage;
    private String descriptionOfAction;
    private String sideEffects;
}
