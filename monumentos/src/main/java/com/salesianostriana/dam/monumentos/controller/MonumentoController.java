package com.salesianostriana.dam.monumentos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.service.MonumentoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController //Controlador tipo REST. Los métodos devuelven datos directamente (JSON) como respuesta HTTP
@RequiredArgsConstructor  //Genera constructor con arg
@RequestMapping("api/monumentos")
public class MonumentoController {
    //inyección dependencias
    private final MonumentoService monumentoService;

    //Lista con todos los monumentos
    @GetMapping("")
    public ResponseEntity<List<Monumento>> todosMonumentos(){
        List<Monumento> monumentos = monumentoService.findAll();
        if (monumentos.isEmpty()){
            return ResponseEntity.notFound().build(); //Si no encuentra ninguno me da un error 404
        }
        return ResponseEntity.ok(monumentos); //Si encuentra la lista me devulve la lista de monumentos
    }

    //Buscar monumento por su id
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> unMonumento(@PathVariable Long id) {
        return ResponseEntity.of(monumentoService.findById(id));

    }


    /*
    @PathVariable en Spring Boot permite extraer valores de la URL de una solicitud y pasarlos como parámetros a los métodos del controlador.
    Específicamente, en el contexto de un controlador REST, @PathVariable se utiliza para obtener partes dinámicas de la ruta definida en
    las anotaciones como @GetMapping, @PostMapping, @PutMapping, etc.
     */


    //Crear un nuevo monumento
    @PostMapping("/monumento")
    public ResponseEntity<Monumento> crearMonumento(@RequestBody Monumento monumento){
        Monumento nuevo = monumentoService.save(monumento);
        return ResponseEntity.status(201).body(nuevo);
    }

    /*
    @RequestBody en Spring Boot se utiliza para vincular el cuerpo de una solicitud HTTP a un objeto en el metodo del controlador.
    Cuando un cliente envía una solicitud con datos (generalmente en formato JSON o XML), Spring convierte automáticamente esos datos al tipo de objeto correspondiente,
    que luego puede ser manipulado dentro del metodo.
     */


    //Actualizar monumento
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editarMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        return monumentoService.findById(id).map(m -> {
            m.setNombreCiudad(monumento.getNombreCiudad());
            m.setCodigoPais(monumento.getCodigoPais());
            m.setNombrePais(monumento.getNombrePais());
            m.setDescripcion(monumento.getDescripcion());
            m.setLatitud(monumento.getLatitud());
            m.setLongitud(monumento.getLongitud());
            m.setNombreMonumento(monumento.getNombreMonumento());
            m.setImagen(monumento.getImagen());

            // Guardar los cambios y devolver el Monumento actualizado
            return ResponseEntity.ok(monumentoService.save(m));
        }).orElse(ResponseEntity.notFound().build());
    }

    //Eliminar monumento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMonumento(@PathVariable Long id) {
        if (monumentoService.findById(id).isPresent()) {
            monumentoService.delete(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }
         return ResponseEntity.notFound().build(); // 404 Not Found

    }

}