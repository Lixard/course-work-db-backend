package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.DrugMapper;
import ru.student.backend.db.model.Drug;
import ru.student.backend.services.dto.DrugDto;
import ru.student.backend.services.mapstruct.DrugStruct;
import ru.student.backend.services.service.DrugService;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    private final DrugMapper drugMapper;
    private final DrugStruct drugStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public DrugServiceImpl(DrugMapper drugMapper,
                           DrugStruct drugStruct) {
        this.drugMapper = drugMapper;
        this.drugStruct = drugStruct;
    }

    @Override
    public List<DrugDto> getDrugs() {
        return drugStruct.toDto(drugMapper.getDrugs());
    }

    @Override
    public DrugDto findById(int id) {
        return drugStruct.toDto(drugMapper.findById(id));
    }

    @Override
    public DrugDto insert(DrugDto drugDto) {
        Drug drug = drugStruct.fromDto(drugDto);
        drugMapper.insert(drug);
        return drugStruct.toDto(drug);
    }

    @Override
    public DrugDto update(DrugDto drugDto) {
        drugMapper.update(drugStruct.fromDto(drugDto));
        return drugDto;
    }

    @Override
    public void delete(int id) {
        drugMapper.delete(id);
    }
}
