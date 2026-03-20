package com.quizapp.onlinequiz;

import com.quizapp.onlinequiz.entity.*;
import com.quizapp.onlinequiz.repository.QuizRepository;
import com.quizapp.onlinequiz.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // 1️⃣ Create demo user if not exists
        if(userRepository.findByUsername("demo").isEmpty()) {
            User user = new User();
            user.setUsername("demo");
            user.setPassword("demo123"); // simple password for testing
            userRepository.save(user);
        }

        // 2️⃣ Avoid duplicate quizzes
        if(quizRepository.count() > 0) return;

        // ======================
        // 3️⃣ Java Basics Quiz
        // ======================
        Quiz quiz1 = new Quiz();
        quiz1.setTitle("Java Basics Quiz");
        quiz1.setDuration(5); // 5 minutes

        // Question 1 (MCQ)
        Question q1 = new Question();
        q1.setContent("What is the size of int in Java?");
        q1.setType(QuestionType.MCQ);
        q1.setOptions(Arrays.asList("16 bits","32 bits","64 bits","Depends on OS"));
        q1.setCorrectAnswer("32 bits");
        q1.setQuiz(quiz1);

        // Question 2 (True/False)
        Question q2 = new Question();
        q2.setContent("Java supports multiple inheritance through classes.");
        q2.setType(QuestionType.TRUE_FALSE);
        q2.setCorrectAnswer("false");
        q2.setQuiz(quiz1);

        // Question 3 (Short Answer)
        Question q3 = new Question();
        q3.setContent("Who developed Java?");
        q3.setType(QuestionType.SHORT_ANSWER);
        q3.setCorrectAnswer("James Gosling");
        q3.setQuiz(quiz1);

        quiz1.setQuestions(Arrays.asList(q1,q2,q3));

        quizRepository.save(quiz1);

        // ======================
        // 4️⃣ Spring Boot Quiz
        // ======================
        Quiz quiz2 = new Quiz();
        quiz2.setTitle("Spring Boot Quiz");
        quiz2.setDuration(7); // 7 minutes

        // Question 1 (True/False)
        Question sq1 = new Question();
        sq1.setContent("Spring Boot is developed by Pivotal?");
        sq1.setType(QuestionType.TRUE_FALSE);
        sq1.setCorrectAnswer("true");
        sq1.setQuiz(quiz2);

        // Question 2 (Short Answer)
        Question sq2 = new Question();
        sq2.setContent("Which annotation is used to create a REST controller?");
        sq2.setType(QuestionType.SHORT_ANSWER);
        sq2.setCorrectAnswer("@RestController");
        sq2.setQuiz(quiz2);

        // Question 3 (MCQ)
        Question sq3 = new Question();
        sq3.setContent("Which file is used to configure Spring Boot application properties?");
        sq3.setType(QuestionType.MCQ);
        sq3.setOptions(Arrays.asList("application.properties","pom.xml","settings.xml","config.yml"));
        sq3.setCorrectAnswer("application.properties");
        sq3.setQuiz(quiz2);

        quiz2.setQuestions(Arrays.asList(sq1,sq2,sq3));

        quizRepository.save(quiz2);

        System.out.println("✅ Demo data loaded successfully!");
    }
}