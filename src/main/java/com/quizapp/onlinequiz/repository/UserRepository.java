package com.quizapp.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequiz.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}