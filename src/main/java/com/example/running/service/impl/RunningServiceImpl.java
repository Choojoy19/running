package com.example.running.service.impl;

import com.example.running.models.Running;
import com.example.running.repository.RunningRepo;
import com.example.running.service.RunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RunningServiceImpl implements RunningService {

    @Autowired
    private RunningRepo runningRepo;

    public RunningServiceImpl(RunningRepo runningRepo) {
        this.runningRepo = runningRepo;
    }


    @Override
    public List<Running> findRunningsByUserId(Integer id) {
        return runningRepo.findRunningsByUserId(id);
    }

    @Override
    public Running findById(Integer id) {
        return runningRepo.getById(id);
    }

    @Override
    public Running save(Running running) {
        return runningRepo.save(running);
    }

    @Override
    public void deleteById(Integer id) {
    runningRepo.deleteById(id);
    }

}
