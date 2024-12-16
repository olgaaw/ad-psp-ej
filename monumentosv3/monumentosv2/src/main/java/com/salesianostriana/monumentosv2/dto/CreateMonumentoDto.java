package com.salesianostriana.monumentosv2.dto;

import com.salesianostriana.monumentosv2.model.Monumento;

public record CreateMonumentoDto(
        String codigoPais,
        String nombrePais,
        String nombreCiudad,
        double latitud,
        double longitud,
        String nombreMonumento,
        String descripcionMonumento,
        String imagenMonumento
) {

    public Monumento toMonumento() {
        return new Monumento(null, this.codigoPais, this.nombrePais, this.nombreCiudad, this.latitud, this.longitud, this.nombreMonumento, this.descripcionMonumento, this.imagenMonumento);
    }

}