package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.DoctorDto;
import ru.student.backend.services.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/doctors",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    List<DoctorDto> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/{id}")
    DoctorDto getDoctorById(@PathVariable("id") int id) {
        return doctorService.findById(id);
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

}
