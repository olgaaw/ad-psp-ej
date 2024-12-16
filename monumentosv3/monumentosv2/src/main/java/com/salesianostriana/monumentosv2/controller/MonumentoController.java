package com.salesianostriana.monumentosv2.controller;

import com.salesianostriana.monumentosv2.dto.GetMonumentoListDto;
import com.salesianostriana.monumentosv2.model.Monumento;
import com.salesianostriana.monumentosv2.repository.MonumentoRepository;
import com.salesianostriana.monumentosv2.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;
    //private final MonumentoService monumentoService;

    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                 "id": 1,
                                                 "codigoPais": "ES",
                                                 "nombrePais": "España",
                                                 "nombreCiudad": "Sevilla",
                                                 "latitud": 37.386207,
                                                 "longitud": -5.99255572619863,
                                                 "nombreMonumento": "La Giralda",
                                                 "descripcionMonumento": "La Giralda es la torre campanario de la catedral de Santa María de la Sede de la ciudad de Sevilla, en Andalucía.",
                                                 "imagenMonumento": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/800px-La_Giralda_August_2012_Seville_Spain.jpg"
                                                 },
                                                 {
                                                     "id": 2,
                                                     "codigoPais": "IT",
                                                     "nombrePais": "Italia",
                                                     "nombreCiudad": "Pisa",
                                                     "latitud": 43.70853,
                                                     "longitud": 10.4036,
                                                     "nombreMonumento": "Torre de Pisa",
                                                     "descripcionMonumento": "La torre de Pisa o torre inclinada de Pisa es la torre campanario de la catedral de Pisa, situada en la plaza del Duomo de Pisa, en la ciudad del mismo nombre, municipio de la región italiana de la Toscana y capital de la provincia homónima de Italia.",
                                                     "imagenMonumento": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/The_Leaning_Tower_of_Pisa_SB.jpeg/800px-The_Leaning_Tower_of_Pisa_SB.jpeg"
                                                 },
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping
    public ResponseEntity<List<Monumento>> getAll() {
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    /*@GetMapping
    public GetMonumentoListDto getAll(
            @RequestParam() ,
            @RequestParam()
    ) {
        return GetMonumentoListDto.of(
                monumentoService.query(max, sortDirection));
    }*/

    @Operation(summary = "Obtiene un monumento por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Monumento encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetMonumentoListDto.class))),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Monumento editado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetMonumentoListDto.class))),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id, @RequestBody Monumento monument) {
        return ResponseEntity.of(monumentoRepository.edit(id, monument));
    }

    @Operation(summary = "Elimina un monumento por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Monumento eliminado",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();
    }



}
