package ru.student.backend.services.service;

import ru.student.backend.services.dto.DrugDto;

import java.util.List;

public interface DrugService {
    List<DrugDto> getDrugs();

    DrugDto findById(int id);

    DrugDto insert(DrugDto drugDto);

    DrugDto update(DrugDto drugDto);

    void delete(int id);
}
