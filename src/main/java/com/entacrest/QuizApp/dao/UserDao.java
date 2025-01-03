package com.entacrest.QuizApp.dao;


import com.entacrest.QuizApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDao extends JpaRepository<User, Long> {
}
