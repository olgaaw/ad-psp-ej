package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repositories.MonumentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepositorio monumentoRepositorio;

    public Monumento save (Monumento monumento) {
        return monumentoRepositorio.save(monumento);
    }

    public Optional<Monumento> findById(Long id) {
        return monumentoRepositorio.findById(id);
    }

    public List<Monumento> findAll() {
        return monumentoRepositorio.findAll();
    }


    public void delete(Long id) {
        monumentoRepositorio.deleteById(id);
    }

}
