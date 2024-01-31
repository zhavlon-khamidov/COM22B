package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.Task;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;
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



    @PutMapping("task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTask.setId(id);
        return ResponseEntity.ok().body(taskRepository.save(updatedTask));
    }


    @DeleteMapping("task/{id}")
    public Task deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        taskRepository.deleteById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
    }

    //TODO: HW create PATCH request.

    // The difference between PUT and PATCH request is
    // for put request you have to provide all fields of data
    // but for patch request you can provide only editing fields
    // so your program have to recognize provided fields and edit
    // only that field in DB


}
