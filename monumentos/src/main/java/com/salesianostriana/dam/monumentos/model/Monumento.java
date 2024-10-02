package com.salesianostriana.dam.monumentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //Marca la clase Monumento como una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos. Cada instancia de esta clase representa una fila en dicha tabla.
@Data  //Genera automáticamente los getters, setters, toString(), hashCode(), y equals() para todos los campos.
@Builder  //Proporciona un patrón de diseño Builder, permitiendo crear objetos de forma más fluida y legible.
@NoArgsConstructor  //Genera un constructor sin argumentos.
@AllArgsConstructor  //Genera un constructor con todos los argumentos (inicializa todos los campos).
public class Monumento {

    @Id  //Clave primaria de la entidad
    @GeneratedValue  //Generación automática
    private Long id;

    //@Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String codigoPais, nombrePais, nombreCiudad, nombreMonumento;

    @Column(columnDefinition = "varchar(600)")
    private String descripcion;

    @Column(columnDefinition = "varchar(255)")
    private String imagen;

    private Integer latitud, longitud;  //Están declaradas como Integer, lo que significa que pueden ser nulas (a diferencia de un tipo primitivo como int).

}