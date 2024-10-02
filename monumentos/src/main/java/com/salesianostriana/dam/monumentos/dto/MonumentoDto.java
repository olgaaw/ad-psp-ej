package com.salesianostriana.dam.monumentos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonumentoDto {
    private Long id;
    private String nombre;
    private String loc;
    private String ubicacion;
    private String imagen;

}