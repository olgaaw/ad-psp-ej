package com.salesianos.__modeladodatos1.repository;

import com.salesianos.__modeladodatos1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
