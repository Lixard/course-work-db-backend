package ru.student.backend.services.service.export;

import java.io.IOException;
import java.time.LocalDateTime;

public interface AppointmentExportToExcelService {
    byte[] export(LocalDateTime date) throws IOException;
}
