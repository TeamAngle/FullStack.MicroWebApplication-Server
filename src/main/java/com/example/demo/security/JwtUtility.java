package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

/**
 * utility jwt utility class with methods to generate a jwt upon a sucessful username and password authentication
 * and verify a jwt and the authorization header based on the algorithm secret
 */
@Component
public class JwtUtility {

    //TODO move secret to configuration (external)
    private String jwtSecret = "secret";


    public String generateJwt(String userPrincipal) {
        return Jwts.builder()
                .setSubject(userPrincipal)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusSeconds(900)))
                .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
                .compact();
    }

    public boolean validateJwt(String bearerToken) throws AuthenticationException {
        String jwt = removeBearerToken(bearerToken);
        try {
            Jwts.parser()
                    .setSigningKey(this.jwtSecret)
                    .parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("There was an error validating jwt");
        }
    }

    public String removeBearerToken(String bearerToken) {
        return bearerToken.substring(6);
    }



}
