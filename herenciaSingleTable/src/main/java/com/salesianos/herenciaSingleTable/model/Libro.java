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
@DiscriminatorColumn(name="1")
public class Libro extends Producto{
    private String autor;
    private String titulo;
    private String editorial;
    private int numeroPaginas;

}
