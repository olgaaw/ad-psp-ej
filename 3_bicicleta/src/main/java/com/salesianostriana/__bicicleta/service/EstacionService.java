package com.salesianostriana.__bicicleta.service;


import com.salesianostriana.__bicicleta.model.Bicicleta;
import com.salesianostriana.__bicicleta.model.Estacion;
import com.salesianostriana.__bicicleta.model.Uso;
import com.salesianostriana.__bicicleta.repository.BicicletaRepository;
import com.salesianostriana.__bicicleta.repository.EstacionRepository;
import com.salesianostriana.__bicicleta.repository.UsoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;
    private final BicicletaRepository bicicletaRepository;

    public List<Estacion> findAll() {
        List<Estacion> result = estacionRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No existen estaciones con esos criterios de busqueda");
        return result;
    }

    public Estacion findById(Long id) {
        return estacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe ninguna estacion con id: " + id));
    }

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    public Estacion edit(Estacion estacion, Long id) {
        return estacionRepository.findById(id)
                .map(old -> {
                    old.setNumero((estacion.getNumero()));
                    old.setNombre(estacion.getNombre());
                    old.setCoordenadas(estacion.getCoordenadas());
                    old.setCapacidad(estacion.getCapacidad());
                    return estacionRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay estaciones con el id:" + id));
    }

    public void delete(Long id) {
        estacionRepository.deleteById(id);
    }

}
