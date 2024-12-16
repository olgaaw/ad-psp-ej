package com.salesianostriana.ejerciciodto.apartado1.repository;

import com.salesianostriana.ejerciciodto.apartado1.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}


/*
    findAll(): Recupera todos los registros de la tabla Alumno.
    findById(Long id): Busca un registro por su ID.
    save(Alumno alumno): Guarda un nuevo registro o actualiza uno existente.
    delete(Alumno alumno): Elimina un registro específico.
    deleteById(Long id): Elimina un registro por su ID.
    count(): Devuelve el número de registros en la tabla.
*/