package com.ezdi.services;

import com.ezdi.beans.Role;
import com.ezdi.beans.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by EZDI\ganesh.s on 14/7/16.
 */
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    // TODO: Please implement the remaning the fields
    private String username;
    private String password;
    private Role[] roles;

    public UserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().toArray(new Role[0]);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
