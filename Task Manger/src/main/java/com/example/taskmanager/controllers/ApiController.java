package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.Task;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    private final TaskRepository taskRepository;

    public ApiController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("task")
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("task/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @PostMapping("task")
    public Task createTask(@RequestBody Task task) {
        System.out.println("before save: " + task.toString());
        return taskRepository.save(task);
    }


    //TODO: HW create put and delete requests
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return null;
    }


    public Task deleteTask(@PathVariable Long id) {
        return null;
    }


}
