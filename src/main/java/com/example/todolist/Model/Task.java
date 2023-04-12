package com.example.todolist.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


/**
 * Task Class - a task that a user would create to be completed
 * Columns:
 * id - unique identifier
 * task - String value of task
 * isCompleted - the state of whether the task is completed or not
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String task;

    @Column
    private boolean isCompleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "accountFK")
    private Account account;
}
