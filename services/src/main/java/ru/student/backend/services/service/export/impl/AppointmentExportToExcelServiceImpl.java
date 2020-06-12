package ru.student.backend.services.service.export.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.dto.DrugDto;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.PatientDiagnosesService;
import ru.student.backend.services.service.PrescriptionOfDrugsService;
import ru.student.backend.services.service.export.AppointmentExportToExcelService;
import ru.student.backend.services.service.export.ExportToExcelService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;


@Service
public class AppointmentExportToExcelServiceImpl extends AbstractExportToExcelService<ComplicatedAppointmentDto> implements ExportToExcelService, AppointmentExportToExcelService {

    private final PatientDiagnosesService patientDiagnosesService;
    private final PrescriptionOfDrugsService prescriptionOfDrugsService;
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentExportToExcelServiceImpl(PatientDiagnosesService patientDiagnosesService,
                                               PrescriptionOfDrugsService prescriptionOfDrugsService,
                                               AppointmentService appointmentService) {
        this.patientDiagnosesService = patientDiagnosesService;
        this.prescriptionOfDrugsService = prescriptionOfDrugsService;
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
        createCell(row, 6, "Diagnoses");
        createCell(row, 7, "Drugs");
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

            StringJoiner joiner = new StringJoiner(", ");
            for (DiagnosisDto diagnosis : patientDiagnosesService.getAppointmentDiagnoses(element.getAppointmentId())) {
                joiner.add(diagnosis.getDiagnosisName());
            }
            createCell(row, 6, joiner.toString());

            joiner = new StringJoiner(", ");
            for (DrugDto drug : prescriptionOfDrugsService.getPrescriptionsOfDrugs(element.getAppointmentId())) {
                joiner.add(drug.getName());
            }
            createCell(row, 7, joiner.toString());
        });
    }

    @Override
    public byte[] export(LocalDateTime date) throws IOException {
        appointmentService.getComplicatedAppointmentsEarlierThan(date).forEach(System.out::println);
        return createExport(appointmentService.getComplicatedAppointmentsEarlierThan(date));
    }
}
