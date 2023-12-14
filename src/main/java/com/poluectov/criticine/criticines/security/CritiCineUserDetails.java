package com.poluectov.criticine.criticines.security;

import com.poluectov.criticine.criticines.model.User;
import com.poluectov.criticine.criticines.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CritiCineUserDetails implements UserDetails {

    String name;
    String password;
    int status;
    private Collection<SimpleGrantedAuthority> authorities;

    public CritiCineUserDetails(User user) {
        this.name = user.getName();
        this.password = user.getPasswordHash();
        this.status = user.getStatus();
        authorities = new ArrayList<>();
        setAuthorities(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (status == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    private void setAuthorities(User user) {

        UserRole role = user.getRole();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.USER.name()));
        if (role.equals(UserRole.ADMIN)){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.ADMIN.name()));
        }
    }
}
