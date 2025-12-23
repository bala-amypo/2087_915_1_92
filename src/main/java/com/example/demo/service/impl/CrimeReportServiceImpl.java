package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository reportRepo;

    public CrimeReportServiceImpl(CrimeReportRepository reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        if(report.getLatitude()< -90 || report.getLatitude()>90) throw new RuntimeException("Latitude out of range");
        if(report.getLongitude()< -180 || report.getLongitude()>180) throw new RuntimeException("Longitude out of range");
        if(report.getOccurredAt()==null) report.setOccurredAt(java.time.LocalDateTime.now());
        return reportRepo.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return reportRepo.findAll();
    }
}
