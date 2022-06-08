package com.example.running.service;

import com.example.running.models.Running;

import java.util.List;

public interface RunningService {
    List<Running> findRunningsByUserId (Integer id);
    Running findById (Integer id);
    Running save(Running running);
    void deleteById(Integer id);

}
