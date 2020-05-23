package ru.student.backend.services.service;

import ru.student.backend.services.dto.PrescriptionOfDrugsDto;

import java.util.List;

public interface PrescriptionOfDrugsService {
    List<PrescriptionOfDrugsDto> getPrescriptionsOfDrugs(int appointmentId);

    PrescriptionOfDrugsDto findById(int appointmentId, int drugId);

    PrescriptionOfDrugsDto insert(PrescriptionOfDrugsDto prescriptionOfDrugsDto);

    void delete(int appointmentId, int drugId);
}
