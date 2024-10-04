package com.example.springboot.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.springboot.domain.users.AppUser;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret; // Não é criada na classe, é criada nas variáveis de ambiente da aplicação.

    public String generateToken(AppUser appUser) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("products-api")
                .withSubject(appUser.getLogin())
                .withExpiresAt(genExpirationDate())
                .sign(algorithm);
            
            return token;
        } catch (JWTCreationException jwtException) {
            throw new RuntimeException("Error while generating token: ", jwtException);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
