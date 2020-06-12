package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.util.List;


@Service
public class AppointmentExportToExcelServiceImpl extends AbstractExportToExcelService<ComplicatedAppointmentDto> implements ExportToExcelService {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentExportToExcelServiceImpl(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public byte[] export() throws IOException {
        return createExport(appointmentService.getComplicatedAppointments());
    }

    @Override
    void fillColumnNames(XSSFSheet sheet) {
        Row row = sheet.createRow(rownum);

        createCell(row, 0, "ID");
        createCell(row, 1, "Doctor");
        createCell(row, 2, "Patient");
        createCell(row, 3, "Date");
        createCell(row, 4, "Place");
        createCell(row, 5, "Symptoms");
    }

    @Override
    void fillData(XSSFSheet sheet, List<ComplicatedAppointmentDto> data) {
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
