package com.salesianostriana.monumentosv2.repository;

import com.salesianostriana.monumentosv2.model.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monumento.builder()
                .id(1L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Sevilla")
                .latitud(37.386207)
                .longitud(-5.99255572619863)
                .nombreMonumento("La Giralda")
                .descripcionMonumento("La Giralda es la torre campanario de la catedral de Santa María de la Sede de la ciudad de Sevilla, en Andalucía.")
                .imagenMonumento("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/800px-La_Giralda_August_2012_Seville_Spain.jpg")
                .build());

        add(Monumento.builder()
                .id(2L)
                .codigoPais("IT")
                .nombrePais("Italia")
                .nombreCiudad("Pisa")
                .latitud(43.70853)
                .longitud(10.4036)
                .nombreMonumento("Torre de Pisa")
                .descripcionMonumento("La torre de Pisa o torre inclinada de Pisa es la torre campanario de la catedral de Pisa, situada en la plaza del Duomo de Pisa, en la ciudad del mismo nombre, municipio de la región italiana de la Toscana y capital de la provincia homónima de Italia.")
                .imagenMonumento("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/The_Leaning_Tower_of_Pisa_SB.jpeg/800px-The_Leaning_Tower_of_Pisa_SB.jpeg")
                .build());

        add(Monumento.builder()
                .id(3L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Granada")
                .latitud(38.9424300)
                .longitud(-3.0335700)
                .nombreMonumento("Alhambra")
                .descripcionMonumento("Consiste en un conjunto de antiguos palacios, jardines y fortalezas inicialmente concebido para alojar al emir y la corte del reino Nazarí, más tarde como residencia de los reyes de Castilla y de sus representantes.")
                .imagenMonumento("https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Dawn_Charles_V_Palace_Alhambra_Granada_Andalusia_Spain.jpg/1280px-Dawn_Charles_V_Palace_Alhambra_Granada_Andalusia_Spain.jpg")
                .build());
    }

    public Monumento add(Monumento monumento) {
        monumentos.put(monumento.getId(), monumento);
        return monumento;
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public Optional<Monumento> edit(Long id, Monumento newValue) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCodigoPais(newValue.getCodigoPais());
            v.setNombrePais(newValue.getNombrePais());
            v.setNombreCiudad(newValue.getNombreCiudad());
            v.setLatitud(newValue.getLatitud());
            v.setLongitud(newValue.getLongitud());
            v.setNombreMonumento(newValue.getNombreMonumento());
            v.setDescripcionMonumento(newValue.getDescripcionMonumento());
            v.setImagenMonumento(newValue.getImagenMonumento());
            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }




}
