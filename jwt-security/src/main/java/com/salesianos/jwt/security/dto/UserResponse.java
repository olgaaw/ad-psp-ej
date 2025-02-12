package com.salesianos.jwt.security.dto;

import com.salesianos.jwt.security.model.User;

import java.util.UUID;

public record UserResponse(
        UUID id, String username
) {

    public static UserResponse of (User user) {


    }
}
