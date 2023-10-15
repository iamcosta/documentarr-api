package dev.kitnet.documentarapi.rest.controller;


import dev.kitnet.documentarapi.domain.entity.Responsavel;
import dev.kitnet.documentarapi.service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/responsaveis")
@RequiredArgsConstructor
public class ResponavelController {

    private final ResponsavelService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsavel create(@RequestBody @Valid Responsavel responsavel) {
        return service.save(responsavel);
    }

    @PutMapping(path = "/{id}")
    public Responsavel update(@PathVariable Long id, @RequestBody @Valid Responsavel responsavel) {
        responsavel.setId(id);
        return service.save(responsavel);
    }
}
