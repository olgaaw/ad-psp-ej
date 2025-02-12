package com.salesianos.jwt.security.controller;

import com.salesianos.jwt.security.dto.CreateUserRequest;
import com.salesianos.jwt.security.dto.UserResponse;
import com.salesianos.jwt.security.model.User;
import com.salesianos.jwt.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> register(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));


    }
}
