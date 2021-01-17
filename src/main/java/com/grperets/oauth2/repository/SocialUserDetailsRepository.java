package com.grperets.oauth2.repository;


import com.grperets.oauth2.entity.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserDetailsRepository extends JpaRepository<SocialUser, String> {

}
