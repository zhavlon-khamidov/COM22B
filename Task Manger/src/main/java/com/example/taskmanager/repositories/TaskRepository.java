package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {

}
