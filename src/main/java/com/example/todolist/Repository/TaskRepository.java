package com.example.todolist.Repository;

import com.example.todolist.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository has the basic query methods find by id, find all, save, delete
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
}
