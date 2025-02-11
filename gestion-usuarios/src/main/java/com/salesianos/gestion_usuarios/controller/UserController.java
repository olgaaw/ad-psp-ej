package com.salesianos.gestion_usuarios.controller;

import com.salesianos.gestion_usuarios.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


}
