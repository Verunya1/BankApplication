package com.VeraRchik.bankapplication.repository;

import com.VeraRchik.bankapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
    Long deleteByLogin(String login);

//    Optional<User> findByToken(String token);

}