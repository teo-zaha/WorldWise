package com.worldwise.backend;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuizService {
    @Value("classpath:quizzes.json")
    private Resource quizzesResource;

    // Read quizzes.json file and return a list of Quiz objects
    // You can use Jackson library to parse JSON to Java objects
    public List<Quiz> getQuizzes() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(quizzesResource.getInputStream(), new TypeReference<List<Quiz>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error: Quiz list could not get mapped properly");
        }
    }

    // Find the quiz by name and return the corresponding Quiz object
    public Quiz getQuiz(String name) {
        List<Quiz> quizzes = getQuizzes();
        for (Quiz quiz : quizzes) {
            if (quiz.getName().equals(name)) {
                return quiz;
            }
        }
        return null;
    }

    // Read the corresponding JSON file and return a list of Question objects
    public List<Question> getQuestions(String quizName) {
        Quiz quiz = getQuiz(quizName);
        if (quiz != null) {
            String fileName = quiz.getFile();
            Resource resource = new ClassPathResource(fileName);
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(resource.getInputStream(), new TypeReference<List<Question>>() {});
            } catch (IOException e) {
                throw new RuntimeException("Error: Questions list could not get mapped properly");
            }
        }
        return null;
    }
}
