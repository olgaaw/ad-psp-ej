package com.salesianos.__modeladodatos1.service;

import com.salesianos.__modeladodatos1.model.Categoria;
import com.salesianos.__modeladodatos1.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No hay categorias con esos criterios");
        }

        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hay categoria con el id"+id));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                        old.setNombre(categoria.getNombre());
                        return categoriaRepository.save(old);
                }).orElseThrow(() -> new EntityNotFoundException("No hay categoria con el id"+id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }


}
