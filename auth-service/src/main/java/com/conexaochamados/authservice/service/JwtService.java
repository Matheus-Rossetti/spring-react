package com.conexaochamados.authservice.service;


import com.conexaochamados.authservice.model.TechnicianModel;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${api.security.token.secret}")
    private String secretKey;

    private SecretKey getSignKey(){
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(@Email String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt( new Date(System.currentTimeMillis()))
                .signWith(getSignKey(), Jwts.SIG.HS256)
                .compact();
    }
}
