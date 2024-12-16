package com.salesianostriana.ejerciciodto.apartado2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre, descripcion;
    private double pvp;
    private List<String> imagenes;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
