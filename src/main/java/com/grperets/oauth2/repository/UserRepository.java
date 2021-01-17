package com.grperets.oauth2.repository;



import com.grperets.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    Optional<User> findByPhone(String phone);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
