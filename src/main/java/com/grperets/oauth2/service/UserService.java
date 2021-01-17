package com.grperets.oauth2.service;


import com.grperets.oauth2.dto.RegistrationRequestDto;
import com.grperets.oauth2.entity.User;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User registerNewUserAccount(RegistrationRequestDto requestDto);


    //User getUser(String verificationToken);

   // void saveRegisteredUser(User user);

    //VerificationToken getVerificationToken(String VerificationToken);


    User addUser(OidcUser oidcUser);

    User register(User user);

    List<User> getAll();

    User findByName(String name);

    User findById(Long id);

    User findByEmail(String email);

    User findByPhone(String phone);

    boolean confirmUser(User user);

    void delete(Long id);
}
