package com.salesianos.herenciaSingleTable.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name="2")
public class Videojuego extends Producto{
    private double duracion;
    private String genero;
    private int pegi;
    private String plataforma;


}
