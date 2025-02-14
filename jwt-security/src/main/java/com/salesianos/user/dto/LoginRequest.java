package com.salesianos.user.dto;


public record LoginRequest(
        String username, String password
) {
}