package com.salesianostriana.ejerciciodto.apartado1.controller;


import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import com.salesianostriana.ejerciciodto.apartado1.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/")
@RequiredArgsConstructor
public class CursoController {

    private final CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        List<Curso> cursos = cursoRepository.findAll();
        if (cursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Long id) {
        return ResponseEntity.of(cursoRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        if (cursoRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoRepository.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id) {
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
