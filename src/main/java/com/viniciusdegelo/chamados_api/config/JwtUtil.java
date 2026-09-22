package com.viniciusdegelo.chamados_api.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key chaveSecreta = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long tempoExpiracao = 1000 * 60 * 60; // 1 hora em milissegundos

    public String gerarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao))
                .signWith(chaveSecreta)
                .compact();
    }

    public String extrairUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(chaveSecreta)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(chaveSecreta).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}