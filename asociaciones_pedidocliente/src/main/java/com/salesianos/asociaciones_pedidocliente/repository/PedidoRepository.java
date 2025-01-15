package com.salesianos.asociaciones_pedidocliente.repository;

import com.salesianos.asociaciones_pedidocliente.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
