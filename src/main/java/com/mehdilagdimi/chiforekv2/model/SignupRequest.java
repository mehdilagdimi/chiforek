package com.mehdilagdimi.chiforekv2.model;


import com.mehdilagdimi.chiforekv2.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequest {

    private String email;
    private String username;
    private String tele;
    private String password;
    private UserRole role;

}