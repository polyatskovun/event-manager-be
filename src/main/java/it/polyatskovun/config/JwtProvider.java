package it.polyatskovun.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
@Component
public class JwtProvider {

    private final String secretKey = "yourSecretKey"; // Замініть на безпечний ключ

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 години
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()                      // Використовуйте parserBuilder
                .setSigningKey(secretKey.getBytes())              // Передайте ключ у вигляді байтів
                .build()                                          // Побудуйте JwtParser
                .parseClaimsJws(token)                            // Парсинг токена
                .getBody();                                       // Отримайте Claims

        return claims.getSubject(); // Повертає значення "sub" (ім'я користувача)
    }
}
