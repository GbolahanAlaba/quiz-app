package com.entacrest.QuizApp.controller;


import com.entacrest.QuizApp.model.User;
import com.entacrest.QuizApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<?>  userController(@RequestBody User user) {
        String rawPassword = user.getPassword();
        return userService.registerUser(user, rawPassword);
    }

}
