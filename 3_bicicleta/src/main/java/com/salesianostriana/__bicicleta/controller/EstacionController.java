package com.salesianostriana.__bicicleta.controller;


import com.salesianostriana.__bicicleta.dto.GetEstacionDto;
import com.salesianostriana.__bicicleta.model.Estacion;
import com.salesianostriana.__bicicleta.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion/")
public class EstacionController {

    private final EstacionService estacionService;

    @GetMapping
    public List<GetEstacionDto> getAll(){
        return estacionService.findAll()
                .stream()
                .map(GetEstacionDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public GetEstacionDto findById(@PathVariable Long id){
        return GetEstacionDto.of(estacionService.findById(id));
    }

    @PostMapping
    public GetEstacionDto save(@RequestBody Estacion estacion){
        return GetEstacionDto.of(estacionService.save(estacion));
    }

    @PutMapping("/{id}")
    public GetEstacionDto edit(@RequestBody Estacion estacion, @PathVariable("id") Long id){
        return GetEstacionDto.of(estacionService.edit(estacion, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        estacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
