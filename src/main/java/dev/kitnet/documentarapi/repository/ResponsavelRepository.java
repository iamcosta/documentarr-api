package dev.kitnet.documentarapi.repository;

import dev.kitnet.documentarapi.domain.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>, JpaSpecificationExecutor<Responsavel> {
}
