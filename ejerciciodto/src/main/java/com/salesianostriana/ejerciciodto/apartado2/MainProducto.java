package com.salesianostriana.ejerciciodto.apartado2;

import com.salesianostriana.ejerciciodto.apartado2.model.Categoria;
import com.salesianostriana.ejerciciodto.apartado2.model.Producto;

public class MainProducto {
    public static void main(String[] args) {

        Categoria categoria = Categoria.builder()
                .id(1L)
                .nombre("Videojuegos")
                .build();


        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Pokemon")
                .descripcion("Juego de pokemon")
                .pvp(69.99)
                .build();

    }
}
