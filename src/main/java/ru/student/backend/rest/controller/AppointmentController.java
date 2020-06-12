package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.*;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.PatientDiagnosesService;
import ru.student.backend.services.service.PrescriptionOfDrugsService;
import ru.student.backend.services.service.export.AppointmentExportToExcelService;
import ru.student.backend.services.service.export.ExportToExcelService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        path = "/appointments",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientDiagnosesService patientDiagnosesService;
    private final PrescriptionOfDrugsService prescriptionOfDrugsService;
    private final ExportToExcelService exportToExcelService;
    private final AppointmentExportToExcelService appointmentExportToExcelService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService,
                                 PatientDiagnosesService patientDiagnosesService,
                                 PrescriptionOfDrugsService prescriptionOfDrugsService,
                                 @Qualifier("appointmentExportToExcelServiceImpl") ExportToExcelService exportToExcelService,
                                 AppointmentExportToExcelService appointmentExportToExcelService) {
        this.appointmentService = appointmentService;
        this.patientDiagnosesService = patientDiagnosesService;
        this.prescriptionOfDrugsService = prescriptionOfDrugsService;
        this.exportToExcelService = exportToExcelService;
        this.appointmentExportToExcelService = appointmentExportToExcelService;
    }

    @GetMapping
    List<AppointmentDto> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping("/complicated")
    List<ComplicatedAppointmentDto> getComplicatedAppointments() {
        return appointmentService.getComplicatedAppointments();
    }

    @GetMapping("/complicated/{date}")
    List<ComplicatedAppointmentDto> getComplicatedAppointmentsEarlierThan(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime date) {
        return appointmentService.getComplicatedAppointmentsEarlierThan(date);
    }

    @GetMapping("/{id}")
    AppointmentDto getAppointmentById(@PathVariable("id") int id) {
        return appointmentService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.insert(appointmentDto);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    AppointmentDto updateAppointment(@PathVariable("id") int id, @RequestBody AppointmentDto appointmentDto) {
        appointmentDto.setAppointmentId(id);
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping("/{id}")
    void deleteAppointment(@PathVariable("id") int id) {
        appointmentService.delete(id);
    }

    @GetMapping("/{id}/diagnoses")
    List<DiagnosisDto> getAppointmentDiagnoses(@PathVariable("id") int appointmentId) {
        return patientDiagnosesService.getAppointmentDiagnoses(appointmentId);
    }

    @PostMapping("/{appointmentId}/diagnoses/{diagnosisId}")
    PatientDiagnosesDto createAppointmentDiagnosis(@PathVariable("appointmentId") int appointmentId, @PathVariable("diagnosisId") int diagnosisId) {
        return patientDiagnosesService.insert(new PatientDiagnosesDto(appointmentId, diagnosisId));
    }

    @GetMapping("/{id}/drugs")
    List<DrugDto> getAppointmentDrugs(@PathVariable("id") int appointmentId) {
        return prescriptionOfDrugsService.getPrescriptionsOfDrugs(appointmentId);
    }

    @PostMapping("/{appointmentId}/drugs/{drugId}")
    PrescriptionOfDrugsDto createAppointmentDrug(@PathVariable("appointmentId") int appointmentId, @PathVariable("drugId") int drugId) {
        return prescriptionOfDrugsService.insert(new PrescriptionOfDrugsDto(appointmentId, drugId));
    }

    @DeleteMapping("/{appointmentId}/diagnoses/{diagnosisId}")
    void deleteAppointmentDiagnosis(@PathVariable("appointmentId") int appointmentId, @PathVariable("diagnosisId") int diagnosisId) {
        patientDiagnosesService.delete(appointmentId, diagnosisId);
    }

    @DeleteMapping("/{appointmentId}/drugs/{drugId}")
    void deleteAppointmentDrug(@PathVariable("appointmentId") int appointmentId, @PathVariable("diagnosisId") int diagnosisId) {
        prescriptionOfDrugsService.delete(appointmentId, diagnosisId);
    }

    @GetMapping(value = "/export", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    byte[] exportExcel(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=appointments.xlsx");
        return exportToExcelService.export();
    }

    @GetMapping(value = "/export/{date}", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    byte[] exportExcelWithDateEarlierThan(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime date) throws IOException {
        return appointmentExportToExcelService.export(date);
    }
}
