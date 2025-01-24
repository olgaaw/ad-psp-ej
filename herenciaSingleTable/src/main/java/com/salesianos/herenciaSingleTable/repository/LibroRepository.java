package com.salesianos.herenciaSingleTable.repository;

import com.salesianos.herenciaSingleTable.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
