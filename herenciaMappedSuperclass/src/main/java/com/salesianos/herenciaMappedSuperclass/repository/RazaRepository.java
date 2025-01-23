package com.salesianos.herenciaMappedSuperclass.repository;

import com.salesianos.herenciaMappedSuperclass.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RazaRepository extends JpaRepository<Raza, Long> {
}
