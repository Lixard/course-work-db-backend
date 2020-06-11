package ru.student.backend.services.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;

public interface ExportToExcelService {
    byte[] export() throws IOException;

    default void createCell(Row row, int column, String data) {
        Cell cell = row.createCell(column, CellType.STRING);
        cell.setCellValue(data);
    }

    default void createCell(Row row, int column, int data) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(data);
    }

}
