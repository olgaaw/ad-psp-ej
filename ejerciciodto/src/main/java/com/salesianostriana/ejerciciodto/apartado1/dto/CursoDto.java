package com.salesianostriana.ejerciciodto.apartado1.dto;

import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDto {
    private Long id;
    private String nombre, tipo, tutor;
    private int aula;

    public CursoDto cursoDto(Curso curso) {
        return CursoDto.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .tipo(curso.getTipo())
                .tutor(curso.getTutor())
                .aula(curso.getAula())
                .build();
    }
}
