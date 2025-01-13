package com.salesianos.data.dto;

public record GetProductoDto(
        Long id,
        String nombre,
        double precio,
        GetCategoriaDto getCategoriaDto
) {
}
