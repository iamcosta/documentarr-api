package dev.kitnet.documentarapi.service;

import dev.kitnet.documentarapi.domain.enums.Acesso;
import dev.kitnet.documentarapi.domain.model.Permissao;
import dev.kitnet.documentarapi.domain.model.Usuario;
import dev.kitnet.documentarapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository
                .findUsuarioByLogin(username)
                .orElseThrow(() -> new IllegalStateException("Usuário/Senha inválidos"));
        List<String> roles = usuario
                .getPermissoes()
                .stream()
                .map(permissao -> "ROLE_" + permissao.getAcesso().toString())
                .toList();
        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .authorities(roles.toArray(new String[0]))
                .build();
    }

    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }
}
