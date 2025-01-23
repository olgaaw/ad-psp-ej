package com.salesianos.__modeladodatos1.service;

import com.salesianos.__modeladodatos1.model.Producto;
import com.salesianos.__modeladodatos1.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public List<Producto> findAll() {
        List<Producto> result = productoRepository.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No hay productos con esos criterios");
        }

        return result;
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe el producto con id " + id));
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto edit(Producto producto, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.getNombre());
                    old.setPvp(producto.getPvp());
                    return productoRepository.save(old);
                }).orElseThrow(() -> new EntityNotFoundException("No existe el producto con id " + id));
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
