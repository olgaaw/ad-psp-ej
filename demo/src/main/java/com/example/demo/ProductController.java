package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "El controlador de producto")
public class ProductController {

    //@Autowired
    private final ProductRepository productRepository;

    @Operation(summary = "Obtiene todos los productos")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",
                    description = "Se han encontrado todos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetProductListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id":1, "name" : "Laptop", "price" : 1234.56},
                                                {"id" : 2, "name" : "Smartphone", "price" : 999.99},
                                            ]
                                            """

                            )}
                    )}
            )
    })
    @GetMapping
    public ResponseEntity<List<Product>> getAll(
            @RequestParam(required = false,
                    value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false,
                    value = "sort", defaultValue = "no") String sortDirection
    ){
         /*
        1. Obtener del repositorio la lista de productos
        2. Si la lista esta vacia devolver 404
        3. Si la lista tiene productos devolver 200 con la lista
         */
        List<Product> result = productRepository.query(max, sortDirection);

        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.of(productRepository.get(id));
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.add(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) {
         return ResponseEntity.of(productRepository.edit(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        productRepository.delete(id);
        return ResponseEntity.noContent().build();
    }



}
