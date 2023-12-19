package dev.kitnet.documentarapi.rest.controller;


import dev.kitnet.documentarapi.domain.model.Responsavel;
import dev.kitnet.documentarapi.service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/responsaveis")
@RequiredArgsConstructor
public class ResponavelController {

    private final ResponsavelService service;

    @GetMapping(path = "/{id}")
    public Responsavel findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize(value = "hasRole('CRIA_RESPONSAVEL')")
    public Responsavel create(@RequestBody @Valid Responsavel responsavel) {
        return service.save(responsavel);
    }

    @PutMapping(path = "/{id}")
    public Responsavel update(@PathVariable Long id, @RequestBody @Valid Responsavel responsavel) {
        responsavel.setId(id);
        return service.save(responsavel);
    }
}
