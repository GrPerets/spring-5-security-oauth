package com.grperets.oauth2.service;


import com.grperets.oauth2.entity.User;
import com.grperets.oauth2.entity.VerificationCode;

public interface VerificationCodeService {


    VerificationCode getVerificationToken(String verificationToken);

    void createVerificationToken(User user, String verificationToken);

    User getUser(String verificationToken);

    void delete(Long id);
}
