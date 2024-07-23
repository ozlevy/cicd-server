package com.example.cicdserver.controller;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.service.CICDJobService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CICDJob> getAllJobs() {
        return cicdJobService.getAllJobs();
    }

    @PostMapping
    public CICDJob createJob(@RequestBody CICDJob cicdJob) {
        return cicdJobService.createJob(cicdJob);
    }

    @GetMapping("/{id}")
    public Optional<CICDJob> getJobById(@PathVariable Long id) {
        return cicdJobService.getJobById(id);
    }

    @PutMapping("/{id}")
    public CICDJob updateJob(@PathVariable Long id, @RequestBody CICDJob cicdJob) {
        return cicdJobService.updateJob(id, cicdJob);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        cicdJobService.deleteJob(id);
    }

    @GetMapping("/status/{status}")
    public List<CICDJob> getJobsByStatus(@PathVariable String status) {
        return cicdJobService.getJobsByStatus(status);
    }

    @GetMapping("/jobType/{jobType}")
    public List<CICDJob> getJobsByJobType(@PathVariable String jobType) {
        return cicdJobService.getJobsByJobType(jobType);
    }

    @GetMapping("/date-range")
    public List<CICDJob> getJobsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return cicdJobService.getJobsByDateRange(startDate, endDate);
    }
}
