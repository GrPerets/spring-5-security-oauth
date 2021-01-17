package com.grperets.oauth2.service.impl;


import com.grperets.oauth2.dto.RegistrationRequestDto;
import com.grperets.oauth2.entity.Role;
import com.grperets.oauth2.entity.Status;
import com.grperets.oauth2.entity.User;
import com.grperets.oauth2.repository.RoleRepository;
import com.grperets.oauth2.repository.UserRepository;
import com.grperets.oauth2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl extends OidcUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public Map<String, Object> getUserClaims() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication.getPrincipal() instanceof OidcUser) {
            OidcUser principal = ((OidcUser) authentication.getPrincipal());
            return principal.getClaims();
        }
        return Collections.emptyMap();
    }




    @Override
    public User addUser(OidcUser oidcUser){


        User user = new User();


        user.setEmail(oidcUser.getEmail());
        user.setName(oidcUser.getName());
        user.setPhone(oidcUser.getPhoneNumber());


        User result = userRepository.findByEmail(user.getEmail()).orElseGet(()->userRepository.save(user));

        return result;
    }


    @Override
    public User registerNewUserAccount(RegistrationRequestDto requestDto)
             {
/*
        if (emailExist(requestDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + requestDto.getEmail());
        }
*/
        User user = new User();
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPhone(requestDto.getPhone());

        List<Role> userRoles = new ArrayList<>();
        Role roleUser = roleRepository.findByName("ROLE_USER");

        userRoles.add(roleUser);

        user.setRoles(userRoles);
        user.setStatus(Status.NOT_ACTIVE);

                 User registeredUser = userRepository.save(user);

                 log.info("IN registerNewUserAccount - user: {} successfully registered", registeredUser);



        return registeredUser;
    }




/*

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
*/

    @Override
    public User register(User user) {

        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.NOT_ACTIVE);


        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByName(String name) {
        Optional<User> result = userRepository.findByName(name);
        log.info("IN findByUsername - user: {} found by username: {}", result, name);
        return result.get();
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }


    @Override
    public User findByEmail(String email) {
        Optional<User> result = userRepository.findByEmail(email);
        log.info("IN findByEmail - user: {} found by email: {}", result, email);
        return result.get();
    }


    @Override
    public User findByPhone(String phone) {
        Optional<User> result = userRepository.findByPhone(phone);
        log.info("IN findByPhone - user: {} found by phone: {}", result, phone);
        return result.get();
    }

    @Override
    public boolean confirmUser(User user) {
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);

        return false;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }


}
