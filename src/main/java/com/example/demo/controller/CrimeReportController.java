package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class CrimeReportController {

    private final CrimeReportService service;

    public CrimeReportController(CrimeReportService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CrimeReport> add(
            @RequestBody CrimeReport report) {

        CrimeReport saved = service.addReport(report);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CrimeReport>> getAll() {

        List<CrimeReport> reports = service.getAllReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}




