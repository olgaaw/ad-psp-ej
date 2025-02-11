package com.salesianos.gestion_usuarios.dto;

public record CreateUserDto(
        String username,
        String password,
        String avatar,
        String fullName
) {
}
