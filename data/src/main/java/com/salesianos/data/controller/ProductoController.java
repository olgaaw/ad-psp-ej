package com.salesianos.data.controller;

import com.salesianos.data.dto.EditProductoCmd;
import com.salesianos.data.dto.GetProductoDto;
import com.salesianos.data.model.Producto;
import com.salesianos.data.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<GetProductoDto> getAll() {
        return productoService.findAll()
                .stream()
                .map(GetProductoDto::of)
                .toList();
    }

    @GetMapping("{id}")
    public GetProductoDto getById(@PathVariable Long id) {
        return GetProductoDto.of(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody EditProductoCmd nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoService.save(nuevo));
    }

    @PutMapping("{id}")
    public Producto edit(@RequestBody EditProductoCmd aEditar, @PathVariable Long id) {
        return productoService.edit(aEditar, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
