package com.salesianostriana.__bicicleta.repository;

import com.salesianostriana.__bicicleta.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
}
