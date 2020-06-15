package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.dto.DoctorDto;
import ru.student.backend.services.dto.PatientWithAppointmentDateDto;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.DoctorService;
import ru.student.backend.services.service.PatientService;
import ru.student.backend.services.service.export.ExportToExcelService;
import ru.student.backend.services.service.export.PatientsPerDoctorWithPeriodExportToExcelService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        path = "/doctors",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final ExportToExcelService exportToExcelService;
    private final PatientsPerDoctorWithPeriodExportToExcelService patientsPerDoctorWithPeriodExportToExcelService;
    private final PatientService patientService;


    @Autowired
    public DoctorController(DoctorService doctorService,
                            AppointmentService appointmentService,
                            @Qualifier("doctorExportToExcelServiceImpl") ExportToExcelService exportToExcelService,
                            PatientsPerDoctorWithPeriodExportToExcelService patientsPerDoctorWithPeriodExportToExcelService,
                            PatientService patientService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.exportToExcelService = exportToExcelService;
        this.patientsPerDoctorWithPeriodExportToExcelService = patientsPerDoctorWithPeriodExportToExcelService;
        this.patientService = patientService;
    }

    @GetMapping
    List<DoctorDto> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/{id}")
    DoctorDto getDoctorById(@PathVariable("id") int id) {
        return doctorService.findById(id);
    }

    @GetMapping("/{id}/appointments/complicated")
    List<ComplicatedAppointmentDto> getComplicatedAppointmentsByDoctor(@PathVariable("id") int doctorId) {
        return appointmentService.getComplicatedAppointmentsByDoctor(doctorId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    DoctorDto createDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorService.insert(doctorDto);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    DoctorDto updateDoctor(@PathVariable("id") int id, @RequestBody DoctorDto doctorDto) {
        doctorDto.setDoctorId(id);
        return doctorService.update(doctorDto);
    }

    @DeleteMapping("{id}")
    void deleteDoctor(@PathVariable("id") int id) {
        doctorService.delete(id);
    }

    @GetMapping(value = "/export", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    byte[] exportDoctorsToExcel(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=doctors.xlsx");
        return exportToExcelService.export();
    }

    @GetMapping(value = "/{doctorId}/patients/{dateStart}/{dateEnd}")
    List<PatientWithAppointmentDateDto> getPatientPerDoctorWithPeriod(@PathVariable("doctorId") int doctorId,
                                                                      @PathVariable("dateStart") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime dateStart,
                                                                      @PathVariable("dateEnd") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime dateEnd) {
        return patientService.getPatientsPerDoctorWithPeriod(doctorId, dateStart, dateEnd);
    }

    @GetMapping(value = "/{doctorId}/patients/{dateStart}/{dateEnd}/export", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    byte[] exportPatientPerDoctorWithPeriodToExcel(@PathVariable("doctorId") int doctorId,
                                                   @PathVariable("dateStart") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime dateStart,
                                                   @PathVariable("dateEnd") @DateTimeFormat(pattern = "dd-MM-yyyy_HH:mm:ss") LocalDateTime dateEnd) throws IOException {
        return patientsPerDoctorWithPeriodExportToExcelService.export(doctorId, dateStart, dateEnd);
    }
}
