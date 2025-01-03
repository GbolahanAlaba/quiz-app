package com.entacrest.QuizApp.dao;

import com.entacrest.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
