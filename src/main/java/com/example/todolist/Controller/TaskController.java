package com.example.todolist.Controller;

import com.example.todolist.Model.Task;
import com.example.todolist.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TaskController {
    TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("task/{id}/task")
    public Task postTask(@PathVariable long accountId, @RequestBody Task task){
        return taskService.createTask(accountId, task);
    }


    @GetMapping("task")
    public List<Task> getAllTasks(){ return taskService.getAllTasks(); }


    @GetMapping("task/{id}")
    public Task getTaskById(@PathVariable long id){ return taskService.getTaskById(id); }


    @PatchMapping("task/{id}")
    public Task updatetask(@PathVariable long id, @RequestBody Task task){
        return taskService.updateTask(id,task);
    }


    @DeleteMapping("task/{id}")
    public Task deleteTask(@PathVariable long id){ return taskService.deleteTask(id); }
}
