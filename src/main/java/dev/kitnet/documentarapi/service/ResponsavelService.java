package dev.kitnet.documentarapi.service;

import dev.kitnet.documentarapi.domain.entity.Responsavel;
import dev.kitnet.documentarapi.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository repository;

    public Responsavel save(Responsavel responsavel) {
        return repository.save(responsavel);
    }
}
