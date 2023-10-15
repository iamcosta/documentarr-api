package dev.kitnet.documentarapi.repository;

import dev.kitnet.documentarapi.domain.entity.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DependenteRepository extends JpaRepository<Dependente, Long>, JpaSpecificationExecutor<Dependente> {
}
