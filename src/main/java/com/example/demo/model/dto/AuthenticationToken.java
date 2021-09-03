package com.example.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationToken extends AbstractAuthenticationToken {

    private String username;
    private String jwt;


    public AuthenticationToken(String username, String jwt) {
        this.username = username;
        this.jwt = jwt;
    }

    public AuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }


    @Override
    public Object getCredentials() {
        return getJwt();
    }

    @Override
    public Object getPrincipal() {
        return getUsername();
    }
}
