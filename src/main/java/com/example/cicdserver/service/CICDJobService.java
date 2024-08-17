package com.example.cicdserver.service;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.repository.CICDJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CICDJobService {
    @Autowired
    private CICDJobRepository cicdJobRepository;

    public List<CICDJob> getAllJobs() {
        return cicdJobRepository.findAll();
    }

    public Optional<CICDJob> getJobById(Long id) {
        return cicdJobRepository.findById(id);
    }

    public CICDJob createJob(CICDJob cicdJob) {
        cicdJob.setCreatedAt(LocalDateTime.now());
        cicdJob.setUpdatedAt(LocalDateTime.now());
        return cicdJobRepository.save(cicdJob);
    }

    public CICDJob updateJob(Long id, CICDJob cicdJob) {
        if (cicdJobRepository.existsById(id)) {
            cicdJob.setId(id);
            cicdJob.setUpdatedAt(LocalDateTime.now());
            return cicdJobRepository.save(cicdJob);
        }
        return null;
    }

    public void deleteJob(Long id) {
        cicdJobRepository.deleteById(id);
    }

    public List<CICDJob> getJobsByStatus(String status) {
        return cicdJobRepository.findByStatus(status);
    }

    public List<CICDJob> getJobsByJobType(String jobType) {
        return cicdJobRepository.findByJobType(jobType);
    }

    public List<CICDJob> getJobsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return cicdJobRepository.findByCreatedAtBetween(startDate, endDate);
    }

}
