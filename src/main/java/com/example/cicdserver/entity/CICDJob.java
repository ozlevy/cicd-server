package com.example.cicdserver.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "cicd_jobs")
@Data
public class CICDJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String jobType;

    public CICDJob() {
        // Default constructor required by JPA
    }

    public CICDJob(Long id, String jobName, String status, LocalDateTime createdAt, LocalDateTime updatedAt, String jobType) {
        this.id = id;
        this.jobName = jobName;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.jobType = jobType;
    }
}
