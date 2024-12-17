package com.salesianostriana.ejerciciodto.apartado2.dto;

import com.salesianostriana.ejerciciodto.apartado2.model.Categoria;
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
    private Categoria categoria;
    private double pvp;

    public static ProductoDto productoDto(Producto producto) {
        return ProductoDto.builder()
                .nombre(producto.getNombre())
                .pvp(producto.getPvp())
                .categoria(producto.getCategoria())
                .build();
    }

}
