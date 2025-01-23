package com.salesianostriana.__bicicleta.repository;

import com.salesianostriana.__bicicleta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
