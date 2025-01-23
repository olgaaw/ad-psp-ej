package com.salesianostriana.__bicicleta.dto;


import com.salesianostriana.__bicicleta.model.Estacion;

public record GetEstacionDto(
        Long id,
        int numero,
        String nombre,
        String coordenadas,
        int capacidad
) {

    public static GetEstacionDto of(Estacion estacion){
        return new GetEstacionDto(
                estacion.getId(),
                estacion.getNumero(),
                estacion.getNombre(),
                estacion.getCoordenadas(),
                estacion.getCapacidad()
        );
    }
}
