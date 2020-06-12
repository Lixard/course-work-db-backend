package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.DrugDto;
import ru.student.backend.services.service.DrugService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.util.List;

@Service
public class DrugExportToExcelServiceImpl extends AbstractExportToExcelService<DrugDto> implements ExportToExcelService {

    private final DrugService drugService;

    @Autowired
    public DrugExportToExcelServiceImpl(DrugService drugService) {
        this.drugService = drugService;
    }

    @Override
    public byte[] export() throws IOException {
        return createExport(drugService.getDrugs());
    }

    @Override
    void fillColumnNames(XSSFSheet sheet) {
        Row row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Name");
        createCell(row, 2, "Method of taking");
        createCell(row, 3, "Dosage");
        createCell(row, 4, "Description of action");
        createCell(row, 5, "Side Effects");
    }

    @Override
    void fillData(XSSFSheet sheet, List<DrugDto> data) {
        data.forEach(element -> {
            rownum++;

            Row row = sheet.createRow(rownum);

            createCell(row, 0, element.getDrugId());
            createCell(row, 1, element.getName());
            createCell(row, 2, element.getMethodOfTaking());
            createCell(row, 3, element.getDosage());
            createCell(row, 4, element.getDescriptionOfAction());
            createCell(row, 5, element.getSideEffects());
        });
    }
}
