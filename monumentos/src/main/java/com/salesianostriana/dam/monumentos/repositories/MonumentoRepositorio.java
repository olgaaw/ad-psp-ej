package com.salesianostriana.dam.monumentos.repositories;

import com.salesianostriana.dam.monumentos.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

//Hereda métodos predefinidos como guardar, actualizar, buscar y eliminar entidades
public interface MonumentoRepositorio extends JpaRepository <Monumento, Long> {
}

/*
    findAll(): Recupera todos los registros de la tabla Monumento.
    findById(Long id): Busca un registro por su ID.
    save(Monumento monumento): Guarda un nuevo registro o actualiza uno existente.
    delete(Monumento monumento): Elimina un registro específico.
    deleteById(Long id): Elimina un registro por su ID.
    count(): Devuelve el número de registros en la tabla.
*/