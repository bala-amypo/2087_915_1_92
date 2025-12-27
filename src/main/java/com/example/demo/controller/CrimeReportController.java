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

    // Add a new report
    @PostMapping
    public CrimeReport addReport(@RequestBody CrimeReport report) {
        return crimeReportService.addReport(report);
    }

    // Get all reports (returns a List)
    @GetMapping
    public List<CrimeReport> getAllReports() {
        return crimeReportService.getAllReports();
    }

    // Get a single report by ID (returns a single object)
    @GetMapping("/{id}")
    public CrimeReport getReportById(@PathVariable Long id) {
        return crimeReportService.getReportById(id);
    }

    // Optional: Delete a report by ID
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        crimeReportService.deleteReport(id);
    }

    // Optional: Update a report
    @PutMapping("/{id}")
    public CrimeReport updateReport(@PathVariable Long id, @RequestBody CrimeReport report) {
        return crimeReportService.updateReport(id, report);
    }
}
