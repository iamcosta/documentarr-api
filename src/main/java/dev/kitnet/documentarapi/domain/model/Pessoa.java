package dev.kitnet.documentarapi.domain.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PESSOA")
@JsonPropertyOrder(value = {"id", "nome", "nascimento", "idade"})
@Data
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo [nome] não pode ser vazio")
    private String nome;

    @NotNull(message = "Campo [nascimento] não pode ser vazio")
    private LocalDate nascimento;

    @Setter(AccessLevel.NONE)
    @Column(name = "tipo", insertable = false, updatable = false)
    private String tipo;

    public Integer getIdade() {
        return Period.between(this.nascimento, LocalDate.now()).getYears();
    }
}
