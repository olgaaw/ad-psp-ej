package com.salesianos.herenciaSingleTable.repository;

import com.salesianos.herenciaSingleTable.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
