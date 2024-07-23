package com.example.cicdserver.controller;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.service.CICDJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class CICDJobController {
    @Autowired
    private CICDJobService cicdJobService;

    @GetMapping
    public ResponseEntity<List<CICDJob>> getAllJobs() {
        List<CICDJob> jobs = cicdJobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CICDJob> createJob(@RequestBody CICDJob cicdJob) {
        CICDJob createdJob = cicdJobService.createJob(cicdJob);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CICDJob> getJobById(@PathVariable Long id) {
        Optional<CICDJob> job = cicdJobService.getJobById(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CICDJob> updateJob(@PathVariable Long id, @RequestBody CICDJob cicdJob) {
        CICDJob updatedJob = cicdJobService.updateJob(id, cicdJob);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        cicdJobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CICDJob>> getJobsByStatus(@PathVariable String status) {
        List<CICDJob> jobs = cicdJobService.getJobsByStatus(status);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/jobType/{jobType}")
    public ResponseEntity<List<CICDJob>> getJobsByJobType(@PathVariable String jobType) {
        List<CICDJob> jobs = cicdJobService.getJobsByJobType(jobType);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<CICDJob>> getJobsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<CICDJob> jobs = cicdJobService.getJobsByDateRange(startDate, endDate);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}
