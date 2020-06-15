package ru.student.backend.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.db.mapper.PatientMapper;
import ru.student.backend.db.model.Patient;
import ru.student.backend.services.dto.PatientDto;
import ru.student.backend.services.dto.PatientWithAppointmentDateDto;
import ru.student.backend.services.mapstruct.PatientStruct;
import ru.student.backend.services.mapstruct.PatientWithAppointmentDateStruct;
import ru.student.backend.services.service.PatientService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;
    private final PatientStruct patientStruct;
    private final PatientWithAppointmentDateStruct patientWithAppointmentDateStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PatientServiceImpl(PatientMapper patientMapper,
                              PatientStruct patientStruct,
                              PatientWithAppointmentDateStruct patientWithAppointmentDateStruct) {
        this.patientMapper = patientMapper;
        this.patientStruct = patientStruct;
        this.patientWithAppointmentDateStruct = patientWithAppointmentDateStruct;
    }

    @Override
    public List<PatientDto> getPatients() {
        return patientStruct.toDto(patientMapper.getPatients());
    }

    @Override
    public List<PatientWithAppointmentDateDto> getPatientsPerDoctorWithPeriod(int doctorId, LocalDateTime dateStart, LocalDateTime dateEnd) {
        return patientWithAppointmentDateStruct.toDto(patientMapper.getPatientsForCurrentDoctorForPeriod(doctorId, dateStart, dateEnd));
    }

    @Override
    public PatientDto findById(int id) {
        return patientStruct.toDto(patientMapper.findById(id));
    }

    @Override
    public PatientDto insert(PatientDto patientDto) {
        Patient patient = patientStruct.fromDto(patientDto);
        patientMapper.insert(patient);
        return patientStruct.toDto(patient);
    }

    @Override
    public PatientDto update(PatientDto patientDto) {
        patientMapper.update(patientStruct.fromDto(patientDto));
        return patientDto;
    }

    @Override
    public void delete(int id) {
        patientMapper.delete(id);
    }
}
