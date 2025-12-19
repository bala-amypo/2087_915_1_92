package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class PatternDetectionResultController {

    private final PatternDetectionService patternDetectionService;

    public PatternDetectionResultController(
            PatternDetectionService patternDetectionService) {
        this.patternDetectionService = patternDetectionService;
    }

    @PostMapping("/{zoneId}")
    public ResponseEntity<PatternDetectionResult> detectPattern(
            @PathVariable Long zoneId) {

        PatternDetectionResult result =
                patternDetectionService.detectPattern(zoneId);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("/{zoneId}")
    public ResponseEntity<List<PatternDetectionResult>> getResults(
            @PathVariable Long zoneId) {

        List<PatternDetectionResult> results =
                patternDetectionService.getResultsByZone(zoneId);

        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}


