package dev.kitnet.documentarapi.rest.controller;

import dev.kitnet.documentarapi.domain.model.Dependente;
import dev.kitnet.documentarapi.rest.dto.DependenteSaveDTO;
import dev.kitnet.documentarapi.service.DependenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/dependentes")
@RequiredArgsConstructor
public class DependenteController {

    private final DependenteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dependente create(@RequestBody @Valid DependenteSaveDTO dependente) {
        return service.save(dependente);
    }

    @PutMapping(path = "/{id}")
    public Dependente update(@PathVariable Long id, @RequestBody @Valid DependenteSaveDTO dependente) {
        dependente.setId(id);
        return service.save(dependente);
    }
}
