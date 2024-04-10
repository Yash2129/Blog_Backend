package com.yash.blog_app.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yash.blog_app.entity.Users;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    // Constructor to initialize UserInfoUserDetails with User entity
    public UserInfoUserDetails(Users userInfo) {
        // Set username, password, and authorities based on user information
        name = userInfo.getUsername();
        password = userInfo.getPassword();
        authorities = Arrays.stream(userInfo.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    // Method to retrieve the authorities granted to the user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Method to retrieve the password used to authenticate the user
    @Override
    public String getPassword() {
        return password;
    }

    // Method to retrieve the username used to authenticate the user
    @Override
    public String getUsername() {
        return name;
    }

    // Method to indicate whether the user's account has not expired
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Method to indicate whether the user is locked or unlocked
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Method to indicate whether the user's credentials (password) has not expired
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Method to indicate whether the user is enabled or disabled
    @Override
    public boolean isEnabled() {
        return true;
    }
}
