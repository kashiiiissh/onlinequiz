package com.quizapp.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {}