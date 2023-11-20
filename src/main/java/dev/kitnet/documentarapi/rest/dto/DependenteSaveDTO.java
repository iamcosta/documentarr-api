package dev.kitnet.documentarapi.rest.dto;

import dev.kitnet.documentarapi.domain.model.Dependente;
import dev.kitnet.documentarapi.domain.model.Responsavel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
public class DependenteSaveDTO {

    private Long id;

    @NotBlank(message = "O campo [nome] é obrigatório")
    private String nome;

    @NotNull(message = "O campo [nascimento] é obrigatório")
    private LocalDate nascimento;

    @NotNull(message = "É obrigatório informar o responsável")
    private Long responsavelId;

    public Dependente toEntity(Responsavel responsavel) {
        Dependente entity = new Dependente();
        BeanUtils.copyProperties(this, entity);
        entity.setResponsavel(responsavel);
        return entity;
    }
}
