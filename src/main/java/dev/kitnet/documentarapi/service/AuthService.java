package dev.kitnet.documentarapi.service;

import dev.kitnet.documentarapi.config.JwtUtil;
import dev.kitnet.documentarapi.domain.model.Usuario;
import dev.kitnet.documentarapi.rest.dto.AuthError;
import dev.kitnet.documentarapi.rest.dto.SessionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity login(String login, String senha) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login, senha));
            String token = jwtUtil.createToken(authentication);
            return ResponseEntity.ok(new SessionDTO(token));
        }catch (BadCredentialsException e){
            AuthError errorResponse = new AuthError(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            AuthError errorResponse = new AuthError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
