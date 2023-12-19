package dev.kitnet.documentarapi.domain.model;

import dev.kitnet.documentarapi.domain.enums.Acesso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String login;

    private String senha;

    @Column(unique = true)
    private String email;

    private String nome;

    @OneToMany
    private List<Permissao> permissoes;

    public Usuario(String login) {
        this.login = login;
    }

    public List<Permissao> getPermissoes() {
        return this.permissoes == null ? new ArrayList<>() : this.permissoes;
    }

    @PrePersist
    private void encodeSenha() {
        this.setSenha(new BCryptPasswordEncoder().encode(this.senha));
    }
}
