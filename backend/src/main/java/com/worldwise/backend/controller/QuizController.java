package com.worldwise.backend.controller;

import com.worldwise.backend.dto.QuizDto;
import com.worldwise.backend.model.Question;
import com.worldwise.backend.model.Quiz;
import com.worldwise.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@AllArgsConstructor
public class QuizController {

    @Autowired
    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getQuizzes() {
        List<QuizDto> quizzes = quizService.getQuizzes();
        return ResponseEntity.ok(quizzes);
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
