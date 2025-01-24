package com.salesianos.mappedSuperclass.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gato extends Animal{
    @Id
    @GeneratedValue
    private Long id;

    private String raza;
    private String color;
    private String tipoPelo;


}
