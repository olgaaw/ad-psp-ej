package com.salesianos.gestion_usuarios.service;

import com.salesianos.gestion_usuarios.dto.CreateUserDto;
import com.salesianos.gestion_usuarios.error.UserNotFoundException;
import com.salesianos.gestion_usuarios.model.User;
import com.salesianos.gestion_usuarios.model.UserRole;
import com.salesianos.gestion_usuarios.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(CreateUserDto userDto, EnumSet<UserRole> roles) {
        User user = User.builder()
                .username(userDto.username())
                .password(userDto.password())
                .avatar(userDto.avatar())
                .fullName(userDto.fullName())
                .roles(roles)
                .build();

        return userRepository.save(user);
    }

    public User edit(User user, UUID id) {
        return userRepository.findById(id)
                .map(old -> {
                    old.setAvatar(user.getAvatar());
                    old.setFullName(user.getFullName());
                    return userRepository.save(old);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User editPassword(String password, UUID id) {
        return userRepository.findById(id)
                .map(old -> {
                    old.setPassword(passwordEncoder.encode(password));
                    return userRepository.save(old);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    public void delete(UUID id) {
        userRepository.deleteById(id);
    }







}
