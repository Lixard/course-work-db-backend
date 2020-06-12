package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public abstract class AbstractExportToExcelService<E> {

    int rownum = 0;

    abstract void fillColumnNames(XSSFSheet sheet);

    abstract void fillData(XSSFSheet sheet, List<E> data);

    byte[] createExport(List<E> data) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        fillColumnNames(sheet);
        fillData(sheet, data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        byte[] file = outputStream.toByteArray();
        outputStream.close();
        rownum = 0;
        return file;
    }

    void createCell(Row row, int column, String data) {
        Cell cell = row.createCell(column, CellType.STRING);
        cell.setCellValue(data);
    }

    void createCell(Row row, int column, int data) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(data);
    }

    void createCell(Row row, int column, long data) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(data);
    }

}
