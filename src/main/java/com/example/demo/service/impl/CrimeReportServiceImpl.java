// package com.example.demo.service.impl;

// import com.example.demo.model.CrimeReport;
// import com.example.demo.repository.CrimeReportRepository;
// import com.example.demo.service.CrimeReportService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class CrimeReportServiceImpl implements CrimeReportService {
    
//     @Autowired
//     private CrimeReportRepository crimeReportRepository;
    
//     public CrimeReportServiceImpl(CrimeReportRepository crimeReportRepository) {
//         this.crimeReportRepository = crimeReportRepository;
//     }
    
//     @Override
//     public CrimeReport addReport(CrimeReport report) {
//         if (report.getLatitude() == null || report.getLatitude() < -90 || report.getLatitude() > 90) {
//             throw new RuntimeException("Invalid latitude");
//         }
//         if (report.getLongitude() == null || report.getLongitude() < -180 || report.getLongitude() > 180) {
//             throw new RuntimeException("Invalid longitude");
//         }
//         return crimeReportRepository.save(report);
//     }
    
//     @Override
//     public List<CrimeReport> getAllReports() {
//         return crimeReportRepository.findAll();
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    @Autowired
    private CrimeReportRepository crimeReportRepository;

    public CrimeReportServiceImpl(CrimeReportRepository crimeReportRepository) {
        this.crimeReportRepository = crimeReportRepository;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        if (report.getLatitude() == null || report.getLatitude() < -90 || report.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude");
        }
        if (report.getLongitude() == null || report.getLongitude() < -180 || report.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude");
        }
        return crimeReportRepository.save(report);
    }

    // 🔴 Updated GET method to ignore old zero-date rows
    @Override
    public List<CrimeReport> getAllReports() {
        return crimeReportRepository.findAll().stream()
                .filter(r -> r.getReportedAt() != null)  // Ignore old zero-date rows
                .collect(Collectors.toList());
    }
}






