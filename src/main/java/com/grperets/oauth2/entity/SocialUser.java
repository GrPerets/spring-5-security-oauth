package com.grperets.oauth2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "socialusers")
@Data
public class SocialUser {
    @Id
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_pic")
    private String userpic;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "locale")
    private String locale;

    @Column(name = "lastvisit")
    private LocalDateTime lastVisit;

}
