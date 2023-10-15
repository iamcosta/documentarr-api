package dev.kitnet.documentarapi.rest.controller;

import dev.kitnet.documentarapi.domain.entity.Pessoa;
import dev.kitnet.documentarapi.repository.specification.filters.PessoaFiltro;
import dev.kitnet.documentarapi.rest.dto.PageDTO;
import dev.kitnet.documentarapi.rest.dto.PessoaPageDTO;
import dev.kitnet.documentarapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping
    public PageDTO<PessoaPageDTO> getPessoaPage(
           @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
            PessoaFiltro filtro
            ) {
        return service.getPessoaPage(filtro, pageable);
    }

    @GetMapping(path = "/{id}")
    public Pessoa getPessoaById(@PathVariable Long id) {
        return service.getPessoaById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
