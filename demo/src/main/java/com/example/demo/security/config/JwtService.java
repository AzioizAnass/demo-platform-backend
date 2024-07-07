package com.example.demo.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY= "47203d6a4b7127495d663d58715262557e286e4c4138587b7b44517177" ;
    //@Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration=604800000;
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateRefreshToken(
            UserDetails userDetails
    ) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken,Claims::getSubject) ;
    }
    private <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        Claims claims = exctractClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims exctractClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<String ,Object>(),userDetails);
    }

    private String generateToken(Map<String, Object> extraClaims , UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public Boolean isTokenValid(String token , UserDetails userDetails){
        final String userName = extractUsername(token);
        return  (userDetails.getUsername().equals(userName) && !isTokenExpired(token));
    }
    private Boolean isTokenExpired(String token){
        return exctractExpiration(token).before(new Date());
    }
    private Date exctractExpiration (String token){
        Date expiration = extractClaim(token , Claims::getExpiration);
        return  expiration;
    }
}
