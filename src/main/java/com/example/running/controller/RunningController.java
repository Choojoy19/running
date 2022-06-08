package com.example.running.controller;

import com.example.running.models.Running;
import com.example.running.service.impl.RunningServiceImpl;
import com.example.running.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RunningController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RunningServiceImpl runningService;

    @GetMapping ("/users/{userId}/runnings")
    public ResponseEntity <List<Running>> getRunningsByUserId (@PathVariable (value="userId") Integer userId){
        List<Running> runnings = runningService.findRunningsByUserId(userId);
        return new ResponseEntity<>(runnings,HttpStatus.OK);
    }

    @PostMapping ("/users/{userId}/runnings")
    public ResponseEntity <Running> createRunning (@PathVariable (value="userId") Integer userId, @RequestBody Running runningReq){
        runningReq.setUser(userService.findById(userId));
        return new ResponseEntity<>(runningService.save(runningReq),HttpStatus.CREATED);
    }

    @PatchMapping ("/runnings/{id}")
    public ResponseEntity <Running> updateRunning (@PathVariable (value="id") Integer id, @RequestBody Running runningReq){
    Running running = runningService.findById(id);
    running = runningReq;
    return new ResponseEntity<>(runningService.save(running), HttpStatus.OK);
    }

    @DeleteMapping ("/runnings/{id}")
    public ResponseEntity<HttpStatus> deleteRunning (@PathVariable (value="id") Integer id){
        runningService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
