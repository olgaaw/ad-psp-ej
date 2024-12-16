package com.salesianostriana.monumentosv2.service;

import com.salesianostriana.monumentosv2.error.MonumentoNotFoundException;
import com.salesianostriana.monumentosv2.model.Monumento;
import com.salesianostriana.monumentosv2.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {
    private final MonumentoRepository monumentoRepository;

    public List<Monumento> getAll() {
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }
    

    public Monumento get(Long id) {
        return monumentoRepository.get(id)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumento add(Monumento monumento) {
        return monumentoRepository.add(monumento);
    }

    public Monumento edit(Long id, Monumento newValue) {
        return monumentoRepository.edit(id, newValue)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public void delete(Long id) {
        monumentoRepository.delete(id);
    }
}
