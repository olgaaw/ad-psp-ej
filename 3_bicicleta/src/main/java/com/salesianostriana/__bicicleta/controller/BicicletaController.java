package com.salesianostriana.__bicicleta.controller;


import com.salesianostriana.__bicicleta.dto.EditBicicletaCmd;
import com.salesianostriana.__bicicleta.dto.GetBicicletaDto;
import com.salesianostriana.__bicicleta.model.Bicicleta;
import com.salesianostriana.__bicicleta.service.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicleta/")
@RequiredArgsConstructor
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @GetMapping
    public List<GetBicicletaDto> getAll(){
        return bicicletaService.findAll()
                .stream()
                .map(GetBicicletaDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public GetBicicletaDto findById(@PathVariable Long id){
        return GetBicicletaDto.of(bicicletaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Bicicleta> save(@RequestBody EditBicicletaCmd bicicleta){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bicicletaService.save(bicicleta));
    }

    @PutMapping("/{id}")
    public Bicicleta edit(@RequestBody EditBicicletaCmd aEditar, @PathVariable("id") Long id){
        return bicicletaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        bicicletaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
