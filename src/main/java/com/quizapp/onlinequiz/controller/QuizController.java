package com.quizapp.onlinequiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.quizapp.onlinequiz.service.QuizService;
import com.quizapp.onlinequiz.service.ResultService;
import com.quizapp.onlinequiz.entity.*;

import java.util.Map;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private ResultService resultService;

    @GetMapping
    public String listQuizzes(Model model) {
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "quiz-list";
    }

    @GetMapping("/{id}")
    public String takeQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.getQuizById(id).orElseThrow();
        model.addAttribute("quiz", quiz);
        return "quiz-take";
    }

    @PostMapping("/{id}/submit")
    public String submitQuiz(@PathVariable Long id,
                             @RequestParam Map<String,String> answers,
                             Model model) {

        Quiz quiz = quizService.getQuizById(id).orElseThrow();
        long score = 0;

        for (Question q : quiz.getQuestions()) {
            String answer = answers.get("q" + q.getId());
            if (answer != null && answer.equalsIgnoreCase(q.getCorrectAnswer())) {
                score++;
            }
        }

        Result result = new Result();
        result.setQuiz(quiz);
        result.setScore(score);
        resultService.saveResult(result);

        model.addAttribute("score", score);
        return "quiz-result";
    }
}