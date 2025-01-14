package com.salesianos.data.controller;

import com.salesianos.data.dto.GetCategoriaDto;
import com.salesianos.data.model.Categoria;
import com.salesianos.data.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<GetCategoriaDto> getAll() {
        return categoriaService.findAll()
                .stream()
                .map(GetCategoriaDto::of)
                .toList();
    }

    @GetMapping("{id}")
    public GetCategoriaDto getById(@PathVariable Long id) {
        return GetCategoriaDto.of(categoriaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(categoria));
    }

    @PutMapping("{id}")
    public Categoria edit(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.edit(categoria, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build(); 
    }

}
