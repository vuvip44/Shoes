package com.vuviet.application.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    
    @Value("${jwt.duration}")
    public Integer duration;

    
    @Value("${jwt.secret}")
    private String secret;

    //Sinh token
    public String generateToken(UserDetails userDetails) {
        
        Map<String, Object> claims = new HashMap<>();

        
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return token;
    }

    //Lấy thông tin được lưu trong token
    public Claims getClaimsFromToken(String token) {
        
        if (token == null) return null;
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return null;
        }
    }
}
