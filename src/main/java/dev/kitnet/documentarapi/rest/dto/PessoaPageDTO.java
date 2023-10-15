package dev.kitnet.documentarapi.rest.dto;

import dev.kitnet.documentarapi.domain.entity.Pessoa;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PessoaPageDTO implements Serializable {

    private Long id;
    private String nome;
    private LocalDate nascimento;
    private Integer idade;
    private String tipo;

    public static PessoaPageDTO fromEnty(Pessoa pessoa) {
        PessoaPageDTO dto = new PessoaPageDTO();
        BeanUtils.copyProperties(pessoa, dto);
        return dto;
    }
}
