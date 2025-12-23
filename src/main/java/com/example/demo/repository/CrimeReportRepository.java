package com.example.demo.repository;

import com.example.demo.model.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    @Query("SELECT COUNT(c) FROM CrimeReport c WHERE c.zone.id = :zoneId")
    int countByZoneId(@Param("zoneId") Long zoneId);
}
