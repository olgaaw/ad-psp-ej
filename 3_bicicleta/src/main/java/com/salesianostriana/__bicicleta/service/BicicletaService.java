package com.salesianostriana.__bicicleta.service;


import com.salesianostriana.__bicicleta.dto.EditBicicletaCmd;
import com.salesianostriana.__bicicleta.model.Bicicleta;
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
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;

    public List<Bicicleta> findAll(){
        List<Bicicleta> result = bicicletaRepository.findAll();
        if(result.isEmpty())
            throw new EntityNotFoundException("No existen bicicletas con esos criterios de busqueda.");
        return result;
    }

    public Bicicleta findById(Long id){
        return bicicletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe ninguna bicicleta con el id: " + id));
    }

    public Bicicleta save(EditBicicletaCmd nuevo){
        return bicicletaRepository.save(Bicicleta.builder()
                .marca(nuevo.marca())
                .modelo(nuevo.modelo())
                .estado(nuevo.estado())
                .estacion(estacionRepository.findById(nuevo.estacionId())
                        .orElseThrow(() -> new EntityNotFoundException("No existe una estacion con ese id")))
                .build()
        );
    }

    public Bicicleta edit(EditBicicletaCmd nueva, Long id){
        return bicicletaRepository.findById(id)
                .map(old -> {
                    old.setMarca(nueva.marca());
                    old.setModelo(nueva.modelo());
                    old.setEstado(nueva.estado());
                    old.setEstacion(estacionRepository.findById(nueva.estacionId())
                            .orElseThrow(() -> new EntityNotFoundException("No existe una estacion con ese id")));
                    return bicicletaRepository.save(old);
                        })
                .orElseThrow(() -> new EntityNotFoundException("No existe una bicicleta con id: " +id));

    }
    
    public void delete(Long id){
        bicicletaRepository.deleteById(id);
    }

}
