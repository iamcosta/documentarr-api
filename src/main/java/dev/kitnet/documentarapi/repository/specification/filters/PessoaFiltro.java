package dev.kitnet.documentarapi.repository.specification.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFiltro {

    private String nome;
    private String tipo;
    private LocalDate nascimento;

}
