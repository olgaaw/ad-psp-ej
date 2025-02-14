package com.salesianos.user.dto;

public record CreateUserRequest(
        String username, String password, String verifyPassword
) {
}
