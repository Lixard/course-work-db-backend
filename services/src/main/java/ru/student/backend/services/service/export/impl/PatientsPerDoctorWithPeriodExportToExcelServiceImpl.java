package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.PatientWithAppointmentDateDto;
import ru.student.backend.services.service.PatientService;
import ru.student.backend.services.service.export.PatientsPerDoctorWithPeriodExportToExcelService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientsPerDoctorWithPeriodExportToExcelServiceImpl extends AbstractExportToExcelService<PatientWithAppointmentDateDto> implements PatientsPerDoctorWithPeriodExportToExcelService {

    private final PatientService patientService;

    @Autowired
    public PatientsPerDoctorWithPeriodExportToExcelServiceImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public byte[] export(int doctorId, LocalDateTime dateStart, LocalDateTime dateEnd) throws IOException {
        return createExport(patientService.getPatientsPerDoctorWithPeriod(doctorId, dateStart, dateEnd));
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
    void fillData(XSSFSheet sheet, List<PatientWithAppointmentDateDto> data) {
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

