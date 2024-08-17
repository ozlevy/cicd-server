package com.example.cicdserver;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.repository.CICDJobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CicdServerApplication.class)
@ActiveProfiles("test")  // Use the 'test' profile to ensure an isolated test environment
public class CICDJobRepositoryTest {

    @Autowired
    private CICDJobRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();  // Clear the table before each test

        // Add new test data
        repository.save(new CICDJob("Job 1", "COMPLETED", "BUILD", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(1)));
        repository.save(new CICDJob("Job 2", "FAILED", "DEPLOY", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(3)));
        repository.save(new CICDJob("Job 3", "PENDING", "TEST", LocalDateTime.now().minusDays(6), LocalDateTime.now().minusDays(5)));
    }

    @Test
    void testFindByStatus() {
        List<CICDJob> jobs = repository.findByStatus("COMPLETED");
        assertEquals(1, jobs.size());
        assertEquals("Job 1", jobs.get(0).getJobName());
    }

    @Test
    void testFindByJobType() {
        List<CICDJob> jobs = repository.findByJobType("DEPLOY");
        assertEquals(1, jobs.size());
        assertEquals("Job 2", jobs.get(0).getJobName());
    }

    @Test
    void testFindByCreatedAtBetween() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(5);
        LocalDateTime endDate = LocalDateTime.now().minusDays(1);

        List<CICDJob> jobs = repository.findByCreatedAtBetween(startDate, endDate);
        assertEquals(2, jobs.size());
    }

    @Test
    void testFindByUpdatedAtBetween() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(5);
        LocalDateTime endDate = LocalDateTime.now().minusDays(1);

        List<CICDJob> jobs = repository.findByUpdatedAtBetween(startDate, endDate);
        assertEquals(2, jobs.size());
    }
}
