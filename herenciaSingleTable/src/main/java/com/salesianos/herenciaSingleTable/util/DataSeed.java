package com.salesianos.herenciaSingleTable.util;

import com.salesianos.herenciaSingleTable.model.Libro;
import com.salesianos.herenciaSingleTable.model.Videojuego;
import com.salesianos.herenciaSingleTable.repository.LibroRepository;
import com.salesianos.herenciaSingleTable.repository.ProductoRepository;
import com.salesianos.herenciaSingleTable.repository.VideojuegoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {
    private final ProductoRepository productoRepository;
    private final VideojuegoRepository videojuegoRepository;
    private final LibroRepository libroRepository;

    @PostConstruct
    public void init() {

        Libro libro = Libro.builder()
                .titulo("El principito")
                .descripcion("Libro de fantasia")
                .autor("a")
                .editorial("Edebé")
                .numeroPaginas(100)
                .precio(9.99)
                .build();
        libroRepository.save(libro);

        Videojuego videojuego = Videojuego.builder()
                .nombre("It takes two")
                .descripcion("Juego cooperativo local")
                .genero("Plataformas")
                .plataforma("Steam")
                .duracion(20)
                .pegi(3)
                .build();
        videojuegoRepository.save(videojuego);



    }
}
