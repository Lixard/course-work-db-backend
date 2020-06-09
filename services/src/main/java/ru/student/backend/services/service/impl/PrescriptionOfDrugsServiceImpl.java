package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.DrugMapper;
import ru.student.backend.db.mapper.PrescriptionsOfDrugsMapper;
import ru.student.backend.db.model.Drug;
import ru.student.backend.db.model.PrescriptionOfDrugs;
import ru.student.backend.services.dto.DrugDto;
import ru.student.backend.services.dto.PrescriptionOfDrugsDto;
import ru.student.backend.services.mapstruct.DrugStruct;
import ru.student.backend.services.mapstruct.PrescriptionOfDrugsStruct;
import ru.student.backend.services.service.PrescriptionOfDrugsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionOfDrugsServiceImpl implements PrescriptionOfDrugsService {

    private final PrescriptionOfDrugsStruct prescriptionOfDrugsStruct;
    private final PrescriptionsOfDrugsMapper prescriptionsOfDrugsMapper;
    private final DrugMapper drugMapper;
    private final DrugStruct drugStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PrescriptionOfDrugsServiceImpl(PrescriptionOfDrugsStruct prescriptionOfDrugsStruct,
                                          PrescriptionsOfDrugsMapper prescriptionsOfDrugsMapper,
                                          DrugMapper drugMapper,
                                          DrugStruct drugStruct) {
        this.prescriptionOfDrugsStruct = prescriptionOfDrugsStruct;
        this.prescriptionsOfDrugsMapper = prescriptionsOfDrugsMapper;
        this.drugMapper = drugMapper;
        this.drugStruct = drugStruct;
    }

    @Override
    public List<DrugDto> getPrescriptionsOfDrugs(int appointmentId) {
        List<PrescriptionOfDrugs> prescriptionsOfDrugs = prescriptionsOfDrugsMapper.getPrescriptionsOfDrugs(appointmentId);
        List<Drug> drugs = new ArrayList<>();
        prescriptionsOfDrugs.forEach(value -> drugs.add(drugMapper.findById(value.getDrugId())));
        return drugStruct.toDto(drugs);
    }

    @Override
    public PrescriptionOfDrugsDto findById(int appointmentId, int drugId) {
        return prescriptionOfDrugsStruct.toDto(prescriptionsOfDrugsMapper.findById(appointmentId, drugId));
    }

    @Override
    public PrescriptionOfDrugsDto insert(PrescriptionOfDrugsDto prescriptionOfDrugsDto) {
        prescriptionsOfDrugsMapper.insert(prescriptionOfDrugsStruct.fromDto(prescriptionOfDrugsDto));
        return prescriptionOfDrugsDto;
    }

    @Override
    public void delete(int appointmentId, int drugId) {
        prescriptionsOfDrugsMapper.delete(appointmentId, drugId);
    }
}
