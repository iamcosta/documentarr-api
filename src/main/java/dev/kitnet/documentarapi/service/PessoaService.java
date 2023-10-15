package dev.kitnet.documentarapi.service;

import dev.kitnet.documentarapi.Exceptions.NotFoundException;
import dev.kitnet.documentarapi.domain.entity.Pessoa;
import dev.kitnet.documentarapi.repository.PessoaRepository;
import dev.kitnet.documentarapi.repository.specification.PessoaSpec;
import dev.kitnet.documentarapi.repository.specification.filters.PessoaFiltro;
import dev.kitnet.documentarapi.rest.dto.PageDTO;
import dev.kitnet.documentarapi.rest.dto.PessoaPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public PageDTO<PessoaPageDTO> getPessoaPage(PessoaFiltro filtro, Pageable pageable) {
        Page<Pessoa> page = repository.findAll(PessoaSpec.createSpecification(filtro), pageable);
        List<PessoaPageDTO> pessoaPageListDTO = page
                .getContent()
                .stream()
                .map(PessoaPageDTO::fromEnty)
                .toList();
        return PageDTO.createPageWithDTOList(pessoaPageListDTO, page);
    }

    public Pessoa getPessoaById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    public void delete(Long id) {
        Pessoa pessoa = getPessoaById(id);
        repository.delete(pessoa);
    }
}
