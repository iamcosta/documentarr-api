package dev.kitnet.documentarapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@DiscriminatorValue("DEPENDENTE")
@Getter
@Setter
public class Dependente extends Pessoa implements Serializable {

    @ManyToOne
    @JsonIgnoreProperties(value = "dependentes")
    private Responsavel responsavel;
}
