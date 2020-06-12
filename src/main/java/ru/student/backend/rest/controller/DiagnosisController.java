package ru.student.backend.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.student.backend.services.dto.DiagnosisDto;
import ru.student.backend.services.service.DiagnosisService;
import ru.student.backend.services.service.export.ExportToExcelService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        path = "/diagnoses",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    private final ExportToExcelService exportToExcelService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService,
                               @Qualifier("diagnosisExportToExcelServiceImpl") ExportToExcelService exportToExcelService) {
        this.diagnosisService = diagnosisService;
        this.exportToExcelService = exportToExcelService;
    }

    @GetMapping
    List<DiagnosisDto> getDiagnoses() {
        return diagnosisService.getDiagnoses();
    }

    @GetMapping("/{id}")
    DiagnosisDto getDiagnosisById(@PathVariable("id") int id) {
        return diagnosisService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    DiagnosisDto createDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        return diagnosisService.insert(diagnosisDto);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    DiagnosisDto updateDiagnosis(@PathVariable("id") int id, @RequestBody DiagnosisDto diagnosisDto) {
        diagnosisDto.setDiagnosisId(id);
        return diagnosisService.update(diagnosisDto);
    }

    @DeleteMapping("/{id}")
    void deleteDiagnosis(@PathVariable("id") int id) {
        diagnosisService.delete(id);
    }

    @GetMapping(value = "/export", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    byte[] exportToExcel(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=diagnoses.xlsx");
        return exportToExcelService.export();
    }
}
