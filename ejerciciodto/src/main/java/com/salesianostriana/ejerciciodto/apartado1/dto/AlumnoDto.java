package com.salesianostriana.ejerciciodto.apartado1.dto;


import com.salesianostriana.ejerciciodto.apartado1.model.Alumno;
import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import com.salesianostriana.ejerciciodto.apartado1.model.Direccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoDto {
    private Long id;
    private String nombre, apellido1, apellido2, email;
    private int telefono;
    private Direccion direccion;
    private Curso curso;

    public AlumnoDto alumnoToDto(Alumno alumno) {
       return AlumnoDto.builder()
               .id(alumno.getId())
               .nombre(alumno.getNombre())
               .apellido1(alumno.getApellido1())
               .apellido2(alumno.getApellido2())
               .email(alumno.getEmail())
               .telefono(alumno.getTelefono())
               .direccion(alumno.getDireccion())
               .curso(alumno.getCurso())
               .build();
    }

}
