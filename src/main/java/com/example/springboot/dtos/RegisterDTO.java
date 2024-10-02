package com.example.springboot.dtos;

import com.example.springboot.domain.users.AppUserRoles;

public record RegisterDTO(String login, String password, AppUserRoles role) {

}
