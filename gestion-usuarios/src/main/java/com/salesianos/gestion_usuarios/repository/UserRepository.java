package com.salesianos.gestion_usuarios.repository;

import com.salesianos.gestion_usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}