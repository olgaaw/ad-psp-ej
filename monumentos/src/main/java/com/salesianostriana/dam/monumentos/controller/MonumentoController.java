package com.salesianostriana.dam.monumentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repositories.MonumentoRepositorio;
import com.salesianostriana.dam.monumentos.dto.MonumentoDto;
import com.salesianostriana.dam.monumentos.dto.MonumentoDtoConverter;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController //Controlador tipo REST. Los métodos devuelven datos directamente (JSON) como respuesta HTTP
@RequiredArgsConstructor  //Genera constructor con arg
@RequestMapping("/monumentos")  //Ruta base del controlador
public class MonumentoController {
    //inyección dependencias
    private final MonumentoRepositorio monumentoRepositorio;
    private final MonumentoDtoConverter monumentoDtoConverter;

    //Lista con todos los monumentos
    @GetMapping("/")
    public ResponseEntity<?> index(){  // <?> indica que el tipo de dato del cuerpo de la respuesta es genérico o indefinido
        List<Monumento> result = monumentoRepositorio.findAll();
        if(result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            List<MonumentoDto> dtoList =
                    result.stream()
                            .map(monumentoDtoConverter::convertMonumento)
                            .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }

    }

    //Buscar monumento por su id
    @GetMapping("/{id}")
    public Monumento unMonumento(@PathVariable Long id) {
        return monumentoRepositorio.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Monumento con ID " + id + " no encontrado")); //Si no encuentra un monumento con el id indicado lanza una excepción estándar de Spring y responde con un código HTTP 404
    }

    /*
    @PathVariable en Spring Boot permite extraer valores de la URL de una solicitud y pasarlos como parámetros a los métodos del controlador.
    Específicamente, en el contexto de un controlador REST, @PathVariable se utiliza para obtener partes dinámicas de la ruta definida en
    las anotaciones como @GetMapping, @PostMapping, @PutMapping, etc.
     */


    //Crear un nuevo monumento
    @PostMapping("/")
    public ResponseEntity<Monumento> nuevoMonumento (@RequestBody Monumento monumento) { //Cuerpo de la solicitud HTTP contiene los datos de un nuevo objeto Monumento en formato JSON, que será convertido a una instancia de la clase Monumento.
        Monumento mon = monumentoRepositorio.save(monumento);
        return new ResponseEntity<Monumento>(mon, HttpStatus.CREATED);
    }

    /*
    @RequestBody en Spring Boot se utiliza para vincular el cuerpo de una solicitud HTTP a un objeto en el metodo del controlador.
    Cuando un cliente envía una solicitud con datos (generalmente en formato JSON o XML), Spring convierte automáticamente esos datos al tipo de objeto correspondiente,
    que luego puede ser manipulado dentro del metodo.
     */


    //Actualizar monumento
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editarMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        return monumentoRepositorio.findById(id).map(m -> {
            m.setNombreCiudad(monumento.getNombreCiudad());
            m.setCodigoPais(monumento.getCodigoPais());
            m.setNombrePais(monumento.getNombrePais());
            m.setDescripcion(monumento.getDescripcion());
            m.setLatitud(monumento.getLatitud());
            m.setLongitud(monumento.getLongitud());
            m.setNombreMonumento(monumento.getNombreMonumento());
            m.setImagen(monumento.getImagen());

            // Guardar los cambios y devolver el Monumento actualizado
            return ResponseEntity.ok(monumentoRepositorio.save(m));
        }).orElse(ResponseEntity.notFound().build());
    }

    //Eliminar monumento
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonumento(@PathVariable Long id) {
        return monumentoRepositorio.findById(id).map(m -> {
            monumentoRepositorio.delete(m);  //Si se encuentra, eliminar el monumento
            return ResponseEntity.noContent().build();  //Devolver 204 No Content
        }).orElse(ResponseEntity.notFound().build());  //Si no se encuentra, devolver 404
    }


}