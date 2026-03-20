package com.quizapp.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {}
