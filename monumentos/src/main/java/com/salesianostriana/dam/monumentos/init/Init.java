package com.salesianostriana.dam.monumentos.init;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repositories.MonumentoRepositorio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final MonumentoRepositorio monumentoRepositorio;

    @PostConstruct
    public void crearMonumento() {

        Monumento monumento1 = new Monumento();

        monumento1.setCodigoPais("ES");
        monumento1.setNombrePais("España");
        monumento1.setNombreCiudad("Sevilla");
        monumento1.setNombreMonumento("Giralda");
        monumento1.setDescripcion("Esto es una descripcion");
        monumento1.setImagen("aqui va la url");
        monumento1.setLatitud(0000000);
        monumento1.setLongitud(0000000);

        monumentoRepositorio.save(monumento1);

        Monumento monumento2 = new Monumento();

        monumento2.setCodigoPais("ES");
        monumento2.setNombrePais("España");
        monumento2.setNombreCiudad("Granada");
        monumento2.setNombreMonumento("Alhambra");
        monumento2.setDescripcion("Esto es una descripcion");
        monumento2.setImagen("aqui va la url");
        monumento2.setLatitud(11111111);
        monumento2.setLongitud(00001111000);

        monumentoRepositorio.save(monumento2);





    }

}
