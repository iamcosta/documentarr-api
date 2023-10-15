package dev.kitnet.documentarapi.repository.specification;

import dev.kitnet.documentarapi.domain.entity.Pessoa;
import dev.kitnet.documentarapi.repository.specification.filters.PessoaFiltro;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaSpec {

    public static Specification<Pessoa> createSpecification(PessoaFiltro filtro) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(filtro.getNome())) {
                predicates.add(SpecUtils.textPredicate(root.get("nome"), filtro.getNome(), criteriaBuilder));
            }
            if (StringUtils.hasText(filtro.getTipo())) {
                predicates.add(criteriaBuilder.equal(root.get("tipo"), filtro.getTipo()));
            }
            if (filtro.getNascimento() != null) {
                predicates.add(criteriaBuilder.equal(root.get("nascimento"), filtro.getNascimento()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
