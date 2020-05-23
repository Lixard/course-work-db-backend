package ru.student.backend.services.mapstruct;

import org.mapstruct.Mapper;
import ru.student.backend.db.model.Drug;
import ru.student.backend.services.dto.DrugDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrugStruct {
    DrugDto toDto(Drug drug);

    Drug fromDto(DrugDto drugDto);

    List<DrugDto> toDto(List<Drug> drugs);

    List<Drug> fromDto(List<DrugDto> drugDtos);
}
