package com.grperets.oauth2.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;




@Entity
@Table(name="verificationcodes")
@Data
public class VerificationCode extends BaseEntity{

    private static final int EXPIRATION = 60*24;

    @Column(name = "code")
    private String code;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }


}
