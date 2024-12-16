package com.salesianostriana.ejerciciodto.apartado1.dto;

import com.salesianostriana.ejerciciodto.apartado1.model.Direccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionDto {
    private Long id;
    private String tipoVia, linea1, linea2, poblacion, provincia;
    private Integer cp;

    public DireccionDto direccionDto(Direccion direccion) {
        return DireccionDto.builder()
                .id(direccion.getId())
                .tipoVia(direccion.getTipoVia())
                .linea1(direccion.getLinea1())
                .linea2(direccion.getLinea2())
                .poblacion(direccion.getPoblacion())
                .provincia(direccion.getProvincia())
                .cp(direccion.getCp())
                .build();
    }
}
