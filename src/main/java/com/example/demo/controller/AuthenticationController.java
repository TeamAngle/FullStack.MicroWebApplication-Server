package com.example.demo.controller;



import com.example.demo.model.dto.RegistrationRequest;
import com.example.demo.model.dto.AuthenticationToken;
import com.example.demo.security.UserDetailsServiceImpl;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationReq) {
        AuthenticationToken response = authenticationService.register(registrationReq);
        return ResponseEntity.ok(response);
    }


}
