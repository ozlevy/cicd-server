package com.example.cicdserver.config;

import com.example.cicdserver.entity.CICDJob;
import com.example.cicdserver.repository.CICDJobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedDatabase(CICDJobRepository cicdJobRepository) {
        return args -> {
            List<CICDJob> jobs = Arrays.asList(
                    new CICDJob("Job1", "Pending", LocalDateTime.now(), LocalDateTime.now(), "Build"),
                    new CICDJob("Job2", "Running", LocalDateTime.now(), LocalDateTime.now(), "Test"),
                    new CICDJob("Job3", "Completed", LocalDateTime.now(), LocalDateTime.now(), "Deploy")
            );
            cicdJobRepository.saveAll(jobs);
        };
    }
}
