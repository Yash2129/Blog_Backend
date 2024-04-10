package com.yash.blog_app.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    // JWT token generated upon successful login
    private String token;

    // Username of the logged-in user
    private String username;

    // Email of the logged-in user
    private String email;

    // Role of the logged-in user
    private String role;

    // Constructor for deserialization
    @JsonCreator
    public LoginResponse(@JsonProperty("token") String token,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email,
            @JsonProperty("role") String role) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // Getter for the JWT token
    public String getToken() {
        return token;
    }

    // Setter for the JWT token
    public void setToken(String token) {
        this.token = token;
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // Setter for the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for the email
    public String getEmail() {
        return email;
    }

    // Setter for the email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the role
    public String getRole() {
        return role;
    }

    // Setter for the role
    public void setRole(String role) {
        this.role = role;
    }
}
