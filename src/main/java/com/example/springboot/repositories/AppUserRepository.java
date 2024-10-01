package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springboot.domain.users.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    UserDetails findByLogin(String login);
}
