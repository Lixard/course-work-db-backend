package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.DiagnosesMapper;
import ru.student.backend.db.model.Diagnosis;
import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.mapstruct.DiagnosisStruct;
import ru.student.backend.services.service.DiagnosisService;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosesMapper diagnosesMapper;
    private final DiagnosisStruct diagnosisStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public DiagnosisServiceImpl(DiagnosesMapper diagnosesMapper,
                                DiagnosisStruct diagnosisStruct) {
        this.diagnosesMapper = diagnosesMapper;
        this.diagnosisStruct = diagnosisStruct;
    }

    @Override
    public List<DiagnosisDto> getDiagnoses() {
        return diagnosisStruct.toDto(diagnosesMapper.getDiagnoses());
    }

    @Override
    public DiagnosisDto findById(int id) {
        return diagnosisStruct.toDto(diagnosesMapper.findById(id));
    }

    @Override
    public DiagnosisDto insert(DiagnosisDto diagnosisDto) {
        Diagnosis diagnosis = diagnosisStruct.fromDto(diagnosisDto);
        diagnosesMapper.insert(diagnosis);
        return diagnosisStruct.toDto(diagnosis);
    }

    @Override
    public DiagnosisDto update(DiagnosisDto diagnosisDto) {
        diagnosesMapper.update(diagnosisStruct.fromDto(diagnosisDto));
        return diagnosisDto;
    }

    @Override
    public void delete(int id) {
        diagnosesMapper.delete(id);
    }
}
