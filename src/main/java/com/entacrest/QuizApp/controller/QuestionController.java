package com.entacrest.QuizApp.controller;


import com.entacrest.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entacrest.QuizApp.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("all-questions")
    public ResponseEntity <List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();

    }

    @GetMapping("category/{category}")
    public ResponseEntity <List<Question>> getQuestionCategory(@PathVariable String category) {
        return  questionService.getAllQuestionsByCategory(category);

    }

    @PostMapping("add-question")
    public ResponseEntity <String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

}
