package com.quizapp.onlinequiz.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.quizapp.onlinequiz.repository.ResultRepository;
import com.quizapp.onlinequiz.entity.Result;
import com.quizapp.onlinequiz.entity.User;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public Result saveResult(Result result) {
        result.setAttemptedAt(LocalDateTime.now());
        return resultRepository.save(result);
    }

    public List<Result> getUserResults(User user) {
        return resultRepository.findByUser(user);
    }
}