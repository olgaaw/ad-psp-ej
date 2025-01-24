package com.salesianos.herenciaMappedSuperclass.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enano extends Raza{
    private String fortaleza;
    private String casa;


}
