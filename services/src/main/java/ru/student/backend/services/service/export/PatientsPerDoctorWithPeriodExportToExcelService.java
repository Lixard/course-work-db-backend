package ru.student.backend.services.service.export;

import java.io.IOException;
import java.time.LocalDateTime;

public interface PatientsPerDoctorWithPeriodExportToExcelService {
    byte[] export(int doctorId, LocalDateTime dateStart, LocalDateTime dateEnd) throws IOException;
}
