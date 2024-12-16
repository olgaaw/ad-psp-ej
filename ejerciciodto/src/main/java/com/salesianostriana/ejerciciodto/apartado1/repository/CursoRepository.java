package com.salesianostriana.ejerciciodto.apartado1.repository;

import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
