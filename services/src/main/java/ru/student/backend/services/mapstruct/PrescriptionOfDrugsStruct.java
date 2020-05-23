package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.PrescriptionOfDrugs;
import ru.student.backend.services.dto.PrescriptionOfDrugsDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionOfDrugsStruct {
    PrescriptionOfDrugsDto toDto(PrescriptionOfDrugs prescriptionOfDrugs);

    PrescriptionOfDrugs fromDto(PrescriptionOfDrugsDto prescriptionOfDrugsDto);

    List<PrescriptionOfDrugsDto> toDto(List<PrescriptionOfDrugs> prescriptionOfDrugs);

    List<PrescriptionOfDrugs> fromDto(List<PrescriptionOfDrugsDto> prescriptionOfDrugsDtos);
}
