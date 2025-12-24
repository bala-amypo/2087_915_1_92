package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class CrimeReportController {
    
    @Autowired
    private CrimeReportService crimeReportService;
    
    @PostMapping
    public CrimeReport addReport(@RequestBody CrimeReport report) {
        return crimeReportService.addReport(report);
    }
    
    @GetMapping
    public List<CrimeReport> getAllReports() {
        return crimeReportService.getAllReports();
    }
}