package com.grperets.oauth2.dto;

import lombok.Data;

@Data
public class RegistrationRequestDto {

    private String name;
    private String email;
    private String phone;
    private String password;
}
