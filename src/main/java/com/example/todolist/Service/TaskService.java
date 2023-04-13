package com.example.todolist.Service;

import com.example.todolist.Model.Account;
import com.example.todolist.Model.Task;
import com.example.todolist.Repository.AccountRepository;
import com.example.todolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * TaskService
 *  - handles the logic and manipulates the data by using the associated repository object
 *  - needs the account repository to add the task with the associated account
 *  - it will be injected into the controller class; it uses these methods for each endpoint
 */
@Service
public class TaskService {
    AccountRepository accountRepository;
    TaskRepository taskRepository;

    /**
     * both repositories use the methods from the JpaRepository to make the queries
     * @param accountRepository account table in database
     * @param taskRepository task table in database
     */
    @Autowired
    public TaskService(AccountRepository accountRepository, TaskRepository taskRepository){
        this.accountRepository = accountRepository;
        this.taskRepository = taskRepository;
    }

    /**
     * adds a task to an account
     * @param accountId id of current Account
     * @param task Task object
     * @return created Task object
     */
    public Task createTask(long accountId, Task task){
        Account account = accountRepository.findById(accountId).get();
        account.getTasks().add(task);
        return taskRepository.save(task);
    }

    /**
     * returns a task by id
     * @param id id of Task object
     * @return Task object specified by id
     */
    public Task getTaskById(long id){ return taskRepository.findById(id).get(); }

    /**
     * returns all the tasks in current account
     * @return a list of Task objects
     */
    public List<Task> getAllTasks(){ return taskRepository.findAll(); }

    /**
     * updates the existing Task object
     * @param id id of Task to be updated
     * @param updateTask Task object with the updates from input
     * @return updated Task object
     */
    public Task updateTask(long id, Task updateTask){
        Task task = getTaskById(id);
        task.setTask(updateTask.getTask());
        task.setCompleted(updateTask.isCompleted());
        return taskRepository.save(task);
    }

    /**
     * deletes the task
     * @param id id of task object to be deleted
     * @return deleted Task object
     */
    public Task deleteTask(long id){
        Task task = getTaskById(id);
        taskRepository.delete(task);
        return task;
    }
}
