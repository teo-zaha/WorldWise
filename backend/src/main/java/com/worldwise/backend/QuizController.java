package com.worldwise.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getQuizzes() {
        return quizService.getQuizzes();
    }

    @GetMapping("/{name}")
    public Quiz getQuiz(@PathVariable String name) {
        return quizService.getQuiz(name);
    }

    @GetMapping("/{name}/questions")
    public List<Question> getQuestions(@PathVariable String name) {
        return quizService.getQuestions(name);
    }
}
