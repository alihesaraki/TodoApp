package com.example.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos") // Table name in the database
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String title; // Task title

    private String description; // Task description

    private boolean completed = false; // Completion status (default: not completed)

    private LocalDateTime createdAt = LocalDateTime.now(); // Creation date (default: current time)

    // Method to mark the task as completed
    public void markAsCompleted() {
        this.completed = true;
    }
}
