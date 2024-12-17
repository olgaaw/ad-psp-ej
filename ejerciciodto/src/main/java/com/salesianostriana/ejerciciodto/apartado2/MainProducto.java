package com.salesianostriana.ejerciciodto.apartado2;

import com.salesianostriana.ejerciciodto.apartado2.dto.ProductoDto;
import com.salesianostriana.ejerciciodto.apartado2.model.Categoria;
import com.salesianostriana.ejerciciodto.apartado2.model.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MainProducto {
    @PostConstruct
    public void init() {

        Categoria categoria = Categoria.builder()
                .id(1L)
                .nombre("Videojuegos")
                .build();


        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Pokemon")
                .descripcion("Juego de pokemon")
                .pvp(69.99)
                .categoria(categoria)
                .build();


        ProductoDto productoDto = ProductoDto.productoDto(producto);
        System.out.println(productoDto);
    }
}
