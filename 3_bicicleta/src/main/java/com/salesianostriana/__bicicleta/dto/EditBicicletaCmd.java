package com.salesianostriana.__bicicleta.dto;

public record EditBicicletaCmd(
        String marca,
        String modelo,
        String estado,
        Long estacionId
) {
}
