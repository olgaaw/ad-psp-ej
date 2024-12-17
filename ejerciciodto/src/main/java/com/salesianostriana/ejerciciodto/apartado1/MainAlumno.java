package com.salesianostriana.ejerciciodto.apartado1;

import com.salesianostriana.ejerciciodto.apartado1.dto.AlumnoDto;
import com.salesianostriana.ejerciciodto.apartado1.model.Alumno;
import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import com.salesianostriana.ejerciciodto.apartado1.model.Direccion;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


@Component
public class MainAlumno {
    @PostConstruct
   public void init(){

        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Calle")
                .linea1("Condes de Bustillo")
                .linea2("17")
                .poblacion("Sevilla")
                .provincia("Sevilla")
                .cp(41010)
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("Desarrollo de Interfaces")
                .tipo("Desarrollo")
                .tutor("Miguel")
                .aula(1)
                .build();


        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Olga")
                .apellido1("Valor")
                .apellido2("Wu")
                .email("@trianasalesianos.com")
                .telefono(654321789)
                .direccion(direccion)
                .curso(curso)
                .build();

        AlumnoDto alumnoDto = AlumnoDto.alumnoToDto(alumno);

        System.out.println(alumnoDto);

    }
}
