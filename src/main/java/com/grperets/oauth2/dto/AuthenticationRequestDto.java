package com.grperets.oauth2.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

    private String name;
    private String email;
    private String phone;
    private String password;

}
