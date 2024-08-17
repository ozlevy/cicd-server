package com.example.cicdserver.repository;

import com.example.cicdserver.entity.CICDJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface CICDJobRepository extends JpaRepository<CICDJob, Long> {
    List<CICDJob> findByStatus(String status);
    List<CICDJob> findByJobType(String jobType);
    List<CICDJob> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<CICDJob> findByUpdatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
