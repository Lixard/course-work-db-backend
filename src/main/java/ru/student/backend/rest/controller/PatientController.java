package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.AppointmentDto;
import ru.student.backend.services.dto.ComplicatedAppointmentDto;
import ru.student.backend.services.dto.PatientDto;
import ru.student.backend.services.service.AppointmentService;
import ru.student.backend.services.service.PatientService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/patients",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @Autowired
    public PatientController(PatientService patientService,
                             AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @GetMapping
    List<PatientDto> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/{id}")
    PatientDto getPatientById(@PathVariable int id) {
        return patientService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    PatientDto createPatient(@RequestBody PatientDto patientDto) {
        return patientService.insert(patientDto);
    }

    @GetMapping("/{id}/appointments")
    List<AppointmentDto> getPatientAppointments(@PathVariable("id") int id) {
        return appointmentService.getPatientAppointments(id);
    }

    @GetMapping("/{id}/appointments/complicated")
    List<ComplicatedAppointmentDto> getComplicatedAppointmentsByPatient(@PathVariable("id") int patientId) {
        return appointmentService.getComplicatedAppointmentsByPatient(patientId);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    PatientDto updatePatient(@PathVariable("id") int id, @RequestBody PatientDto patientDto) {
        patientDto.setPatientId(id);
        return patientService.update(patientDto);
    }

    @DeleteMapping("/{id}")
    void deletePatient(@PathVariable("id") int id) {
        patientService.delete(id);
    }

}
