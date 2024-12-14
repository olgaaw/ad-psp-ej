package com.salesianostriana.monumentosv2.controller;

import com.salesianostriana.monumentosv2.model.Monumento;
import com.salesianostriana.monumentosv2.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> getAll() {
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id, @RequestBody Monumento monument) {
        return ResponseEntity.of(monumentoRepository.edit(id, monument));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();
    }



}
