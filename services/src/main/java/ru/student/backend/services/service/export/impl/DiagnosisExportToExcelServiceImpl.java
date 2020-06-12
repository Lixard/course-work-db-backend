package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.service.DiagnosisService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.util.List;

@Service
public class DiagnosisExportToExcelServiceImpl extends AbstractExportToExcelService<DiagnosisDto> implements ExportToExcelService {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisExportToExcelServiceImpl(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @Override
    public byte[] export() throws IOException {
        return createExport(diagnosisService.getDiagnoses());
    }

    @Override
    void fillColumnNames(XSSFSheet sheet) {
        Row row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Name");
    }

    @Override
    void fillData(XSSFSheet sheet, List<DiagnosisDto> data) {
        data.forEach(element -> {
            rownum++;

            Row row = sheet.createRow(rownum);

            createCell(row, 0, element.getDiagnosisId());
            createCell(row, 1, element.getDiagnosisName());
        });
    }
}
