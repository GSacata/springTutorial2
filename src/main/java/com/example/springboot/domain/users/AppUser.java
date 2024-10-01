package com.example.springboot.domain.users;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;

// import com.example.springboot.domain.users.AppUserRoles;

@Table(name="app_users")
@Entity(name="app_users")
// @Getter
// @NoArgsConstructor
// // @AllArgsConstructor
// @EqualsAndHashCode(of="id")
public class AppUser implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String login;
    private String password;
    private AppUserRoles role; // Será feito enum
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRoles getRole() {
        return role;
    }

    public void setRole(AppUserRoles role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        // return null;
        if (this.role == AppUserRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // return UserDetails.super.isAccountNonExpired();
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        // return UserDetails.super.isAccountNonLocked();
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        // return UserDetails.super.isCredentialsNonExpired();
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        // return UserDetails.super.isEnabled();
        return true;
    }
    
}
