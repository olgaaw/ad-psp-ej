package com.salesianos.__modeladodatos1.util;

import com.salesianos.__modeladodatos1.model.Categoria;
import com.salesianos.__modeladodatos1.model.Producto;
import com.salesianos.__modeladodatos1.repository.CategoriaRepository;
import com.salesianos.__modeladodatos1.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void run() {

    Categoria c1 = Categoria.builder()
            .nombre("Sonido")
            .build();

    categoriaRepository.save(c1);

    Categoria c2 = Categoria.builder()
            .nombre("Tecnologia")
            .build();

    categoriaRepository.save(c2);


    Producto p1 = Producto.builder()
            .nombre("Auriculares")
            .pvp(54.99)
            .categoria(c1)
            .build();

    productoRepository.save(p1);


    Producto p2 = Producto.builder()
            .nombre("Teclado")
            .pvp(49.95)
            .categoria(c2)
            .build();

    productoRepository.save(p2);

    categoriaRepository.saveAll(List.of(c1, c2));

    productoRepository.saveAll(List.of(p1, p2));

    }
}
