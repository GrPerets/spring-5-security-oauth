package com.grperets.oauth2.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
@Slf4j
public class VerificationCodeServiceImpl /*implements VerificationTokenService*/ {
/*

    private final VerificationTokenRepository verificationTokenRepository;

    private final MailSender mailSender;


    @Autowired
    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository, MailSender mailSender) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.mailSender = mailSender;
    }


    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return verificationTokenRepository.findByToken(verificationToken);
    }


    @Override
    public void createVerificationToken(User user, String token) {

        //String token = UUID.randomUUID().toString();
        String token1 = RandomString.make(6);

        VerificationToken newToken = new VerificationToken();
        newToken.setUser(user);
        newToken.setToken(token1);
        newToken.setExpiryDate(new VerificationToken().calculateExpiryDate(60));

        newToken.setStatus(Status.ACTIVE);

        verificationTokenRepository.save(newToken);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome. Please, visit next link: http://localhost:8080/api/v1/reg/confirm/%s",
                    user.getEmail(),
                    newToken.getToken()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }


    }

    @Override
    public User getUser(String verificationToken) {

        User user = verificationTokenRepository.findByToken(verificationToken).getUser();

        return user;
    }

    @Override
    public void delete(Long id) {

        verificationTokenRepository.deleteById(id);

    }




 */
}
