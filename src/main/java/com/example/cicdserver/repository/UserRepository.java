package com.example.cicdserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cicdserver.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
