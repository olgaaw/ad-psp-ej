package com.salesianos.jwt.security.dto;

public record CreateUserRequest(
        String username, String password, String verifyPassword
) {
}
