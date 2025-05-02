package com.example.Task_tracker_API.service;

import java.util.List;

import com.example.Task_tracker_API.model.Task;

public interface TaskService {
    
    // Create a new task
    Task createTask(Task task);
    
    // Get all tasks
    List<Task> getAllTasks();
    
    // Get task by ID
    Task getTaskById(Long id);
    
    // Get tasks by status
    List<Task> getTasksByStatus(String status);
    
    // Update task
    Task updateTask(Long id, Task taskDetails);
    
    // Delete task
    void deleteTask(Long id);
    
    // Search tasks by title
    List<Task> searchTasksByTitle(String title);
}

