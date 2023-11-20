package dev.kitnet.documentarapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@DiscriminatorValue("RESPONSAVEL")
@Getter
@Setter
public class Responsavel extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "responsavel", orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    @JsonIgnoreProperties(value = "responsavel", ignoreUnknown = true)
    private List<Dependente> dependentes;

    public void addDependete(Dependente dependente) {
        this.dependentes.add(dependente);
        dependente.setResponsavel(this);
    }

    public List<Dependente> getDependentes() {
        List<Dependente> list = this.dependentes != null && !this.dependentes.isEmpty() ? this.dependentes : new ArrayList<>();
        return Collections.unmodifiableList(list);
    }
}
