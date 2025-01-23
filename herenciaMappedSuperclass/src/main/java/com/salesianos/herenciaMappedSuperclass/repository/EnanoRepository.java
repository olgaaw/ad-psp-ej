package com.salesianos.herenciaMappedSuperclass.repository;

import com.salesianos.herenciaMappedSuperclass.model.Enano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnanoRepository extends JpaRepository<Enano, Long> {
}
