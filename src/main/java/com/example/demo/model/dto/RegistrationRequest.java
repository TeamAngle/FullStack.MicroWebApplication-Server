package com.example.demo.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    private String username;
    private String email;
    private String password;

}
