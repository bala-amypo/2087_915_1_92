package com.example.demo.service.impl;


import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;
import org.springframework.stereotype.Service;


@Service
public class CrimeReportServiceImpl implements CrimeReportService {


private final CrimeReportRepository repo;


public CrimeReportServiceImpl(CrimeReportRepository repo) {
this.repo = repo;
}
@Override
public CrimeReport addCrime(CrimeReport crime) {
CoordinateValidator.validate(crime.getLatitude(), crime.getLongitude());
DateValidator.validatePast(crime.getOccurredAt());
return repo.save(crime);
}
}