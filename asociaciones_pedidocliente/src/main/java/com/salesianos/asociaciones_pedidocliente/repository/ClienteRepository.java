package com.salesianos.asociaciones_pedidocliente.repository;

import com.salesianos.asociaciones_pedidocliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
