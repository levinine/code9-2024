package com.example.splitting.monolith.security;

import com.example.splitting.monolith.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtServiceImpl implements JwtService {

    private final JwtParser jwtParser;
    private final long jwtExpiration;
    private final SecretKey secretKey;

    public JwtServiceImpl(
            @Value("${application.security.jwt.secret-key}") String secretKeyString,
            @Value("${application.security.jwt.expiration}") long jwtExpiration
    ) {
        this.jwtExpiration = jwtExpiration;
        // make secret key
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyString);
        secretKey = Keys.hmacShaKeyFor(keyBytes);
        // make parser
        this.jwtParser = Jwts.parser().verifyWith(secretKey).build();
    }

    @Override
    public String extractUsername(String jwt) {
        return extractClaims(jwt).get("username", String.class);
    }

    @Override
    public Claims extractClaims(String jwt) {
        return (Claims) jwtParser.parse(jwt).getPayload();
    }

    @Override
    public boolean isTokeValid(Claims claims, UserDetails userDetails) {
        if (claims.getExpiration().getTime() < System.currentTimeMillis()) {
            return false;
        }
        return claims.getSubject().equals(userDetails.getUsername());
    }

    @Override
    public String generateToken(User user) {
        var now = System.currentTimeMillis();
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date(now))
                .expiration(new Date(now + jwtExpiration))
                .claims(
                        Map.of(
                                "role",
                                user.getUserRole().name(),
                                "username",
                                user.getUsername()
                        )
                )
                .signWith(secretKey)
                .compact();
    }
}
