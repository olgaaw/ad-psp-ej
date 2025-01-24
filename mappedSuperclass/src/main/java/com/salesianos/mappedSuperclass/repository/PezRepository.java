package com.salesianos.mappedSuperclass.repository;

import com.salesianos.mappedSuperclass.model.Pez;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PezRepository extends JpaRepository<Pez, Long> {
}
