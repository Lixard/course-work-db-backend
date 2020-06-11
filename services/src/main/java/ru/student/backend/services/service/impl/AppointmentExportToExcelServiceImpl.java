package ru.student.backend.services.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.ExportToExcelService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class AppointmentExportToExcelServiceImpl implements ExportToExcelService {

    private final AppointmentService appointmentService;
    private final XSSFWorkbook workbook;

    private int rownum = 0;

    @Autowired
    public AppointmentExportToExcelServiceImpl(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        workbook = new XSSFWorkbook();
    }

    @Override
    public byte[] export() throws IOException {
        XSSFSheet sheet = workbook.createSheet("Data");
        fillColumnNames(sheet);
        fillData(sheet, appointmentService.getComplicatedAppointments());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        byte[] file = outputStream.toByteArray();
        outputStream.close();
        return file;
    }

    private void fillColumnNames(XSSFSheet sheet) {
        Row row;
        row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Doctor");
        createCell(row, 2, "Patient");
        createCell(row, 3, "Date");
        createCell(row, 4, "Place");
        createCell(row, 5, "Symptoms");
    }

    private void fillData(XSSFSheet sheet, List<ComplicatedAppointmentDto> data) {
        data.forEach(element -> {
            rownum++;

            Row row = sheet.createRow(rownum);

            String doctor = element.getDoctor().getLastName() + " "
                    + element.getDoctor().getFirstName().charAt(0) + "."
                    + element.getDoctor().getSecondName().charAt(0) + ".";

            String patient = element.getPatient().getLastName() + " "
                    + element.getPatient().getFirstName().charAt(0) + "."
                    + element.getPatient().getSecondName().charAt(0) + ".";

            createCell(row, 0, element.getAppointmentId());
            createCell(row, 1, doctor);
            createCell(row, 2, patient);
            createCell(row, 3, element.getAppointmentDate());
            createCell(row, 4, element.getPlace());
            createCell(row, 5, element.getSymptoms());
        });
    }
}
