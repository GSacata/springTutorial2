package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springboot.repositories.AppUserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository; // Injeta dependência

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
        return appUserRepository.findByLogin(username);
    }

}
