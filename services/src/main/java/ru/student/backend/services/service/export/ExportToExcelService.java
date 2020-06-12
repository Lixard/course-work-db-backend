package ru.student.backend.services.service.export;

import java.io.IOException;

public interface ExportToExcelService {
    byte[] export() throws IOException;
}
