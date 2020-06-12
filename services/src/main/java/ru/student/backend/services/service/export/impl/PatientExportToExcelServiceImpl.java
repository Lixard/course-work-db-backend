package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.PatientDto;
import ru.student.backend.services.service.PatientService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.util.List;

@Service
public class PatientExportToExcelServiceImpl extends AbstractExportToExcelService<PatientDto> implements ExportToExcelService {

    private final PatientService patientService;

    @Autowired
    public PatientExportToExcelServiceImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public byte[] export() throws IOException {
        return createExport(patientService.getPatients());
    }

    @Override
    void fillColumnNames(XSSFSheet sheet) {
        Row row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Last name");
        createCell(row, 2, "First name");
        createCell(row, 3, "Second name");
        createCell(row, 4, "Sex");
        createCell(row, 5, "Birthday");
        createCell(row, 6, "Policy");
        createCell(row, 7, "Serial");
        createCell(row, 8, "Number");

    }

    @Override
    void fillData(XSSFSheet sheet, List<PatientDto> data) {
        data.forEach(element -> {
            rownum++;

            Row row = sheet.createRow(rownum);

            createCell(row, 0, element.getPatientId());
            createCell(row, 1, element.getLastName());
            createCell(row, 2, element.getFirstName());
            createCell(row, 3, element.getSecondName());
            createCell(row, 4, element.getSex().getLiteral());
            createCell(row, 5, element.getBirthday().toString());
            createCell(row, 6, element.getPolicy());
            createCell(row, 7, element.getSerialPassport());
            createCell(row, 8, element.getNumberPassport());
        });
    }
}
