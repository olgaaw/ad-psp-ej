package com.salesianos.asociaciones_pedidocliente.util;

import com.salesianos.asociaciones_pedidocliente.model.Cliente;
import com.salesianos.asociaciones_pedidocliente.model.Pedido;
import com.salesianos.asociaciones_pedidocliente.repository.ClienteRepository;
import com.salesianos.asociaciones_pedidocliente.repository.PedidoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    @PostConstruct
    public void run() {

        Cliente c = Cliente.builder()
                .nombre("Alfonso")
                .direccion("C Ejemplo")
                .build();

        clienteRepository.save(c);

        Pedido pedido1 = Pedido.builder()
                .codigo("456B")
                .cliente(c)
                .build();

        pedidoRepository.save(pedido1);


    }


}
