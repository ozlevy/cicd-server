package com.example.cicdserver.config;

import com.example.cicdserver.entity.AppUser;
import com.example.cicdserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            AppUser user = new AppUser();
            user.setUsername("sa");
            user.setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);
        };
    }
}
