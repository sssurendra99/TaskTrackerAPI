package com.example.Task_tracker_API.repository;

import com.example.Task_tracker_API.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Find tasks by status
    List<Task> findByStatusIgnoreCase(String status);
    
    // Find tasks by title containing (case-insensitive)
    List<Task> findByTitleContainingIgnoreCase(String title);
}
