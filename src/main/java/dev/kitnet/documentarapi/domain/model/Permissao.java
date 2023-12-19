package dev.kitnet.documentarapi.domain.model;

import dev.kitnet.documentarapi.domain.enums.Acesso;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Acesso acesso;
}
