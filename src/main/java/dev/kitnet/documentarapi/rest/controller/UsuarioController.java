package dev.kitnet.documentarapi.rest.controller;

import dev.kitnet.documentarapi.domain.model.Usuario;
import dev.kitnet.documentarapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody  Usuario usuario) {
        return service.create(usuario);
    }
}
