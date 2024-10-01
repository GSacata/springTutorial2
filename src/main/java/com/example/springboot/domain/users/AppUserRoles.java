package com.example.springboot.domain.users;

public enum AppUserRoles {
    ADMIN("admin"),
    USER("user");

    private String role;

    AppUserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
