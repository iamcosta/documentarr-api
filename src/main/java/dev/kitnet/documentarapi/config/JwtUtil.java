package dev.kitnet.documentarapi.config;

import dev.kitnet.documentarapi.domain.model.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private final String SECRETY_KEY = "documentart-api-key";
    private final Integer TOKEN_EXPIRATION = 5*60*1000;
    private final String TOKEN_PREFIX = "Bearer ";
    private final String TOKEN_HEADER = "Authorization";

    private final JwtParser jwtParser;

    public JwtUtil() {
        this.jwtParser = Jwts.parser().setSigningKey(SECRETY_KEY);
    }

    public String createToken(Authentication auth) {
        Claims claims = Jwts.claims().setSubject(auth.getName());
        Date tokenExpiration = new Date(new Date().getTime() + TOKEN_EXPIRATION);

        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setClaims(claims)
                .claim("roles", authorities)
                .setExpiration(tokenExpiration)
                .signWith(SignatureAlgorithm.HS256, SECRETY_KEY)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser
                .setSigningKey(SECRETY_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    public Collection<? extends GrantedAuthority> getRoles(Claims claims) {
        return Arrays.stream(claims.get("roles").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}
