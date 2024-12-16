package com.salesianostriana.ejerciciodto.apartado1.controller;

import com.salesianostriana.ejerciciodto.apartado1.model.Alumno;
import com.salesianostriana.ejerciciodto.apartado1.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno/")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoRepository alumnoRepository;



    @GetMapping
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        if (alumnos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        return ResponseEntity.of(alumnoRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Long id, @RequestBody Alumno alumno) {
        if (alumnoRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnoRepository.save(alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

