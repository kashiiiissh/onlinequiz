package com.quizapp.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequiz.entity.Result;
import com.quizapp.onlinequiz.entity.User;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUser(User user);
}