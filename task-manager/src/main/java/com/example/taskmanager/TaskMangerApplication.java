package com.example.taskmanager;

import com.example.taskmanager.entities.Task;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskMangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskMangerApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrapData(TaskRepository taskRepository) {

        return new CommandLineRunner(){
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Bootstrap Data Init");

                Task task1 = new Task().setTitle("Task 1")
                        .setDescription("Hello World");

                Task task2 = new Task().setTitle("Task 2")
                        .setDescription("Hello, Com22B");

                System.out.println(taskRepository.save(task1));
                System.out.println(taskRepository.save(task2));
            }
        };

    }

}
