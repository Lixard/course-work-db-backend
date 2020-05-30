package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.DrugDto;
import ru.student.backend.services.service.DrugService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/drugs",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    List<DrugDto> getDrugs() {
        return drugService.getDrugs();
    }

    @GetMapping("/{id}")
    DrugDto getDrugById(@PathVariable("id") int id) {
        return drugService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    DrugDto createDrug(@RequestBody DrugDto drugDto) {
        return drugService.insert(drugDto);
    }

    @PutMapping("/{id}")
    DrugDto updateDrug(@PathVariable("id") int id, @RequestBody DrugDto drugDto) {
        drugDto.setDrugId(id);
        return drugService.update(drugDto);
    }

    @DeleteMapping("/{id}")
    void deleteDrug(@PathVariable("id") int id) {
        drugService.delete(id);
    }
}
