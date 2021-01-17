package com.grperets.oauth2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.grperets.oauth2.entity.User;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());

        return userDto;
    }

}
