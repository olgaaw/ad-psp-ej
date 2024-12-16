package com.salesianostriana.ejerciciodto.apartado1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellido1, apellido2, email;
    private int telefono;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;







}
