package com.salesianos.herenciaMappedSuperclass.util;

import com.salesianos.herenciaMappedSuperclass.model.Enano;
import com.salesianos.herenciaMappedSuperclass.model.Maiar;
import com.salesianos.herenciaMappedSuperclass.repository.EnanoRepository;
import com.salesianos.herenciaMappedSuperclass.repository.MaiarRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {
    private final EnanoRepository enanoRepository;
    private final MaiarRepository maiarRepository;

    @PostConstruct
    public void init() {

        Enano enano1 = Enano.builder()
                .nombre("Durin I, el Inmortal")
                .fuerza(40)
                .inteligencia(40)
                .fortaleza("Khazad-dûm")
                .casa("Barbiluengos")
                .build();
        enanoRepository.save(enano1);

        Enano enano2 = Enano.builder()
                .nombre("Thráin II")
                .fuerza(45)
                .inteligencia(40)
                .fortaleza("Nogrod")
                .casa("Barbas de fuego")
                .build();
        enanoRepository.save(enano2);

        Maiar maiar1 = Maiar.builder()
                .nombre("Gandalf")
                .fuerza(50)
                .inteligencia(50)
                .tipoMagia("Azul")
                .build();
        maiarRepository.save(maiar1);

        Maiar maiar2 = Maiar.builder()
                .nombre("Saruman")
                .fuerza(50)
                .inteligencia(50)
                .tipoMagia("Blanca")
                .build();
        maiarRepository.save(maiar2);















    }
}
