package com.salesianostriana.dam.monumentos.dto;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.dto.MonumentoDto;
import org.springframework.stereotype.Component;


@Component  //Spring la gestionará como un bean y podrá ser utilizada mediante inyección de dependencias en otros componentes del proyecto.
public class MonumentoDtoConverter { // Esta clase es responsable de la conversión de la entidad Monumento a un objeto MonumentoDto.
    public MonumentoDto convertMonumento (Monumento monumento) {
        return MonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombreMonumento())
                .loc(monumento.getLatitud()+","+monumento.getLongitud())
                .ubicacion(monumento.getNombreCiudad()+", " + monumento.getNombrePais()+", " + monumento.getCodigoPais())
                .imagen(monumento.getImagen())
                .build();

    }
}
