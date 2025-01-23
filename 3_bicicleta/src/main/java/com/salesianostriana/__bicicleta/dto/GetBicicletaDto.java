package com.salesianostriana.__bicicleta.dto;


import com.salesianostriana.__bicicleta.model.Bicicleta;

public record GetBicicletaDto(
        Long id,
        String marca,
        String modelo,
        String estado,
        GetEstacionDto estacion
) {
    public static GetBicicletaDto of(Bicicleta bicicleta){
        return new GetBicicletaDto(
                bicicleta.getId(),
                bicicleta.getMarca(),
                bicicleta.getModelo(),
                bicicleta.getEstado(),
                GetEstacionDto.of(bicicleta.getEstacion())
                );
    }
}
