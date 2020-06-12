package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.DoctorDto;
import ru.student.backend.services.service.DoctorService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.util.List;

@Service
public class DoctorExportToExcelServiceImpl extends AbstractExportToExcelService<DoctorDto> implements ExportToExcelService {

    private final DoctorService doctorService;

    @Autowired
    public DoctorExportToExcelServiceImpl(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public byte[] export() throws IOException {
        return createExport(doctorService.getDoctors());
    }

    @Override
    void fillColumnNames(XSSFSheet sheet) {
        Row row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Last name");
        createCell(row, 2, "First name");
        createCell(row, 3, "Second name");
    }

    @Override
    void fillData(XSSFSheet sheet, List<DoctorDto> data) {
        data.forEach(element -> {
            rownum++;

            Row row = sheet.createRow(rownum);

            createCell(row, 0, element.getDoctorId());
            createCell(row, 1, element.getLastName());
            createCell(row, 2, element.getFirstName());
            createCell(row, 3, element.getSecondName());
        });
    }
}
