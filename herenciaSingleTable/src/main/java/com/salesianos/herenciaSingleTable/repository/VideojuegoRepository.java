package com.salesianos.herenciaSingleTable.repository;

import com.salesianos.herenciaSingleTable.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
