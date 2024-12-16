package com.salesianostriana.ejerciciodto.apartado2.dto;

import com.salesianostriana.ejerciciodto.apartado2.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double pvp;

    public ProductoDto productoDto(Producto producto) {
        return ProductoDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .pvp(producto.getPvp())
                .build();
    }

}
