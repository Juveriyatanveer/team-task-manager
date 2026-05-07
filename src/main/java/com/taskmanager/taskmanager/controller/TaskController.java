 package com.taskmanager.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @PutMapping("/updateStatus/{id}")
    public Task updateStatus(@PathVariable Long id,
                             @RequestParam String status) {

        Task task = taskRepository.findById(id).orElse(null);

        if(task != null) {

            task.setStatus(status);

            return taskRepository.save(task);
        }

        return null;
    }
    @GetMapping("/dashboard")
    public String dashboard() {

        long total = taskRepository.count();

        return "Total Tasks : " + total;
    }
}