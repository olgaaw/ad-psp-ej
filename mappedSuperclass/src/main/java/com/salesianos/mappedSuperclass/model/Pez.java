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
public class Pez extends Animal{
    @Id
    @GeneratedValue
    private Long id;

    private String agua;

    private double tamanio;




}
