package com.salesianos.__modeladodatos1.repository;

import com.salesianos.__modeladodatos1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
