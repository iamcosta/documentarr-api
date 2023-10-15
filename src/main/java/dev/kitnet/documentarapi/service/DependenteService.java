package dev.kitnet.documentarapi.service;

import dev.kitnet.documentarapi.Exceptions.BusinessException;
import dev.kitnet.documentarapi.domain.entity.Dependente;
import dev.kitnet.documentarapi.domain.entity.Responsavel;
import dev.kitnet.documentarapi.repository.DependenteRepository;
import dev.kitnet.documentarapi.rest.dto.DependenteSaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DependenteService {

    private final DependenteRepository repository;
    private final PessoaService pessoaService;

    public Dependente save(DependenteSaveDTO dependente) {
        if (dependente.getResponsavelId() == null) throw new BusinessException("Responsável não informado");
        Responsavel responsavel = (Responsavel) pessoaService.getPessoaById(dependente.getResponsavelId());
        return repository.save(dependente.toEntity(responsavel));
    }
}
