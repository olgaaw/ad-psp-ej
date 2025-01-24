package com.salesianos.mappedSuperclass.repository;

import com.salesianos.mappedSuperclass.model.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatoRepository extends JpaRepository<Gato, Long> {
}
