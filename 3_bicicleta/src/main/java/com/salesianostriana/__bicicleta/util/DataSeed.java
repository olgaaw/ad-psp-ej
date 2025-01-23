package com.salesianostriana.__bicicleta.util;

import com.salesianostriana.__bicicleta.model.Bicicleta;
import com.salesianostriana.__bicicleta.model.Estacion;
import com.salesianostriana.__bicicleta.model.Uso;
import com.salesianostriana.__bicicleta.model.Usuario;
import com.salesianostriana.__bicicleta.repository.BicicletaRepository;
import com.salesianostriana.__bicicleta.repository.EstacionRepository;
import com.salesianostriana.__bicicleta.repository.UsoRepository;
import com.salesianostriana.__bicicleta.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
@RequiredArgsConstructor
public class DataSeed {

    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;
    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init(){

        Usuario u = Usuario.builder()
                .nombre("Pepe")
                .numTarjeta(12345)
                .pin(1111)
                .saldo(19.99)
                .build();
        usuarioRepository.save(u);

        Usuario u2 = Usuario.builder()
                .nombre("Paco")
                .numTarjeta(54321)
                .pin(2222)
                .saldo(10)
                .build();
        usuarioRepository.save(u2);

        Estacion e = Estacion.builder()
                .numero(33)
                .nombre("Esteishon")
                .coordenadas("16.778 23.5555")
                .capacidad(120)
                .build();
        estacionRepository.save(e);

        Estacion e2 = Estacion.builder()
                .numero(33)
                .nombre("Estation")
                .coordenadas("22.222 4.444")
                .capacidad(200)
                .build();
        estacionRepository.save(e2);

        Bicicleta b = Bicicleta.builder()
                .marca("Asus")
                .modelo("Rox")
                .estado("Usada")
                .estacion(e)
                .build();
        bicicletaRepository.save(b);

        Bicicleta b2 = Bicicleta.builder()
                .marca("Msi")
                .modelo("Xtreme")
                .estado("Muy Usada")
                .estacion(e2)
                .build();
        bicicletaRepository.save(b2);


        Uso us = Uso.builder()
                .fechaInicio(LocalDate.of(2025, 1, 15))
                .fechaFin(LocalDate.of(2025, 1, 16))
                .coste(2.99)
                .usuario(u)
                .bicicleta(b)
                .estacion(e)
                .build();
        usoRepository.save(us);

        Uso us2 = Uso.builder()
                .fechaInicio(LocalDate.of(2025, 1, 20))
                .fechaFin(LocalDate.of(2025, 1, 21))
                .coste(4.99)
                .usuario(u2)
                .bicicleta(b2)
                .estacion(e2)
                .build();
        usoRepository.save(us2);

        u.addUso(us);
        b.addUso(us);
        e.addUso(us);
        e.addBicicleta(b);

        u2.addUso(us2);
        b2.addUso(us2);
        e2.addUso(us2);
        e2.addBicicleta(b2);

        System.out.println(u);
        System.out.println(e);
        System.out.println(b);
        System.out.println(us);

        System.out.println(u2);
        System.out.println(e2);
        System.out.println(b2);
        System.out.println(us2);

    }
}

