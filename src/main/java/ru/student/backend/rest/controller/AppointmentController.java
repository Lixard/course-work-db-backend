package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.AppointmentDto;
import ru.student.backend.services.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/appointments",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    List<AppointmentDto> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping("/{id}")
    AppointmentDto getAppointmentById(@PathVariable("id") int id) {
        return appointmentService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.insert(appointmentDto);
    }

    @PutMapping("/{id}")
    AppointmentDto updateAppointment(@PathVariable("id") int id, @RequestBody AppointmentDto appointmentDto) {
        appointmentDto.setAppointmentId(id);
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping("/{id}")
    void deleteAppointment(@PathVariable("id") int id) {
        appointmentService.delete(id);
    }
}
