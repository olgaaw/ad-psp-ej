package com.salesianos.jwt.security.service;

import com.salesianos.jwt.security.dto.CreateUserRequest;
import com.salesianos.jwt.security.model.User;
import com.salesianos.jwt.security.model.UserRole;
import com.salesianos.jwt.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);

    }

}
