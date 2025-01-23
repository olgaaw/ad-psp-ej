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
public class Maiar extends Raza{
    private String tipoMagia;


}
