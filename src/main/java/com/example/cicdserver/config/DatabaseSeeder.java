package com.example.cicdserver.config;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.repository.CICDJobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class DatabaseSeeder {
    @Bean
    public CommandLineRunner seedDatabase(CICDJobRepository cicdJobRepository) {
        return args -> {
            CICDJob job1 = new CICDJob();
            job1.setJobName("Job1");
            job1.setStatus("Pending");
            job1.setCreatedAt(LocalDateTime.now());
            job1.setUpdatedAt(LocalDateTime.now());
            job1.setJobType("Build");

            CICDJob job2 = new CICDJob();
            job2.setJobName("Job2");
            job2.setStatus("Completed");
            job2.setCreatedAt(LocalDateTime.now());
            job2.setUpdatedAt(LocalDateTime.now());
            job2.setJobType("Deploy");

            cicdJobRepository.save(job1);
            cicdJobRepository.save(job2);
        };
    }
}
