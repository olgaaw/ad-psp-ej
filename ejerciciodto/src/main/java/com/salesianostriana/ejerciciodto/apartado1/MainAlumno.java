package com.salesianostriana.ejerciciodto.apartado1;

import com.salesianostriana.ejerciciodto.apartado1.model.Alumno;
import com.salesianostriana.ejerciciodto.apartado1.model.Curso;
import com.salesianostriana.ejerciciodto.apartado1.model.Direccion;



public class MainAlumno {
    public static void main(String[] args) {

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


        System.out.println(alumno);



    }
}
