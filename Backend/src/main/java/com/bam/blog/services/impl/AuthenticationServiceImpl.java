package com.bam.blog.services.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.bam.blog.services.AuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String secretKey;

    private final Long jwtExpiryMs = 86400000L;

    @Override
    public UserDetails authenticate(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return userDetails;
    }

    @Override
    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiryMs))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    @Override
    public UserDetails validateToken(String token) {

        String userName = extractUserName(token);

        return userDetailsService.loadUserByUsername(userName);
    }

    private Key getSignInKey() {
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String extractUserName(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build().parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
