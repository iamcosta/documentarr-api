package dev.kitnet.documentarapi.rest.controller;

import dev.kitnet.documentarapi.rest.dto.LoginReqDTO;
import dev.kitnet.documentarapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody LoginReqDTO login) {
        return service.login(login.getLogin(), login.getSenha());
    }
}
