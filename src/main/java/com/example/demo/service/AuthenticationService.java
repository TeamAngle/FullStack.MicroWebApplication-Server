package com.example.demo.service;

import com.example.demo.model.dto.LoginRequest;
import com.example.demo.model.dto.RegistrationRequest;
import com.example.demo.model.dto.AuthenticationToken;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtility;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//TODO institute custom logging in repo

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    JwtUtility jwtUtiliy;


    public AuthenticationToken register(RegistrationRequest registrationReq) {
        //TODO verify that the username doesn't already exist. verify that the email doesn't already exist. throw correct errors if they do exist
        User user = new User();
        user.setUsername(registrationReq.getUsername());
        user.setEmail(registrationReq.getEmail());
        user.setPassword(this.passwordEncoder.encode(registrationReq.getPassword()));
        userRepository.save(user);

        String jwt = jwtUtiliy.generateJwt(user.getUsername());

        return new AuthenticationToken(user.getUsername(), jwt);
    }

    public void login(LoginRequest loginRequest) throws AuthenticationException {
        //send a loginRequest, username and pass, check database to see if username exists
        //if yes, pull it out (find by username) and call password encoder - call decoder on the password of user
        //if they match, then we call our generatejwt method
        String username = loginRequest.getUsername();
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new AuthenticationServiceException("No such user"));

        String encodedPassword = user.getPassword();
        if(validatePassword(encodedPassword, loginRequest)) {
            String jwt = this.jwtUtiliy.generateJwt(username);
            AuthenticationToken token = new AuthenticationToken(username, jwt);
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        throw new AuthenticationException("Invalid credentials");
    }

    private boolean validatePassword(String encodedPassword, LoginRequest loginRequest) {
        String rawPassword = loginRequest.getPassword();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
