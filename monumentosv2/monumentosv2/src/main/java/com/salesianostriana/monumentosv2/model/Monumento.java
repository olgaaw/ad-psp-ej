package com.salesianostriana.monumentosv2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity para JPA
@Data  //Genera automáticamente los getters, setters, toString(), hashCode(), y equals() para todos los campos
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    private Long id;
    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    private String descripcionMonumento;
    private String imagenMonumento;
}
