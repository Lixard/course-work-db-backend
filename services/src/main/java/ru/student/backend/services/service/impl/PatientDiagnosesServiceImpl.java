package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.DiagnosesMapper;
import ru.student.backend.db.mapper.PatientDiagnosesMapper;
import ru.student.backend.db.model.Diagnosis;
import ru.student.backend.db.model.PatientDiagnoses;
import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.dto.PatientDiagnosesDto;
import ru.student.backend.services.mapstruct.DiagnosisStruct;
import ru.student.backend.services.mapstruct.PatientDiagnosesStruct;
import ru.student.backend.services.service.PatientDiagnosesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDiagnosesServiceImpl implements PatientDiagnosesService {

    private final PatientDiagnosesStruct patientDiagnosesStruct;
    private final PatientDiagnosesMapper patientDiagnosesMapper;
    private final DiagnosesMapper diagnosesMapper;
    private final DiagnosisStruct diagnosisStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PatientDiagnosesServiceImpl(PatientDiagnosesStruct patientDiagnosesStruct,
                                       PatientDiagnosesMapper patientDiagnosesMapper,
                                       DiagnosesMapper diagnosesMapper,
                                       DiagnosisStruct diagnosisStruct) {
        this.patientDiagnosesStruct = patientDiagnosesStruct;
        this.patientDiagnosesMapper = patientDiagnosesMapper;
        this.diagnosesMapper = diagnosesMapper;
        this.diagnosisStruct = diagnosisStruct;
    }

    @Override
    public List<DiagnosisDto> getAppointmentDiagnoses(int appointmentId) {
        List<PatientDiagnoses> appointmentDiagnoses = patientDiagnosesMapper.getAppointmentDiagnoses(appointmentId);
        List<Diagnosis> diagnoses = new ArrayList<>();
        appointmentDiagnoses.forEach(value -> diagnoses.add(diagnosesMapper.findById(value.getDiagnosisId())));
        return diagnosisStruct.toDto(diagnoses);
    }

    @Override
    public PatientDiagnosesDto findById(int appointmentId, int diagnosisId) {
        return patientDiagnosesStruct.toDto(patientDiagnosesMapper.findById(appointmentId, diagnosisId));
    }

    @Override
    public PatientDiagnosesDto insert(PatientDiagnosesDto patientDiagnosesDto) {
        patientDiagnosesMapper.insert(patientDiagnosesStruct.fromDto(patientDiagnosesDto));
        return patientDiagnosesDto;
    }

    @Override
    public void delete(int appointmentId, int diagnosisId) {
        patientDiagnosesMapper.delete(appointmentId, diagnosisId);
    }
}
