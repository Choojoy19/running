package com.example.running.controller;

import com.example.running.models.User;
import com.example.running.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public List<User> findAll(){  // пока так
        return userService.findAll();
    }

    @PostMapping ("/registration")
    public String newUser (@RequestBody User newUser){
        User userDb = userService.findByName(newUser.getUsername());

        if (userDb!=null) return "User is exist";
        else {
        } userService.save(newUser);
        return "Succeed";
    }


}
