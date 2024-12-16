package com.salesianostriana.ejerciciodto.apartado1.controller;

import com.salesianostriana.ejerciciodto.apartado1.model.Direccion;
import com.salesianostriana.ejerciciodto.apartado1.repository.DireccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion/")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionRepository direccionRepository;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAll() {
        List<Direccion> direcciones = direccionRepository.findAll();
        if (direcciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getById(@PathVariable Long id) {
        return ResponseEntity.of(direccionRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> update(@PathVariable Long id, @RequestBody Direccion direccion) {
        if (direccionRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccionRepository.save(direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Direccion> delete(@PathVariable Long id) {
        direccionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
