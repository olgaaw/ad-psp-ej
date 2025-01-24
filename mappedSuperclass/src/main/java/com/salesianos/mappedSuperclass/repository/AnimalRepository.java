package com.salesianos.mappedSuperclass.repository;

import com.salesianos.mappedSuperclass.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
