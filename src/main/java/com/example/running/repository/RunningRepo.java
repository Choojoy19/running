package com.example.running.repository;

import com.example.running.models.Running;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunningRepo extends JpaRepository <Running, Integer> {

    List<Running> findRunningsByUserId (Integer id);

}
