package com.salesianostriana.ejerciciodto.apartado2.dto;

import com.salesianostriana.ejerciciodto.apartado2.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDto {
    private Long id;
    private String nombre;

    public CategoriaDto categoriaDto(Categoria categoria) {
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }

}
