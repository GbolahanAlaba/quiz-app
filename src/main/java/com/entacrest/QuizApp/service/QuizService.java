package com.entacrest.QuizApp.service;


import com.entacrest.QuizApp.dao.QuestionDao;
import com.entacrest.QuizApp.dao.QuizDao;
import com.entacrest.QuizApp.model.Question;
import com.entacrest.QuizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try{
            List<Question> question = questionDao.findRandomQuestionsByCategory(category, numQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(question);
            quizDao.save(quiz);

            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error in connection...", HttpStatus.BAD_REQUEST);

    }
}
