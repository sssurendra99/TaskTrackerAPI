package com.example.Task_tracker_API.service;



import com.example.Task_tracker_API.exception.TaskNotFoundException;
import com.example.Task_tracker_API.model.Task;
import com.example.Task_tracker_API.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatusIgnoreCase(status);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        
        // Update task fields
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setDueDate(taskDetails.getDueDate());
        
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        // Check if task exists
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public List<Task> searchTasksByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
}
