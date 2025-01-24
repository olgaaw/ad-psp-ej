package com.salesianos.herenciaMappedSuperclass.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Raza {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    private String nombre;

    private int fuerza;

    private int inteligencia;




}
