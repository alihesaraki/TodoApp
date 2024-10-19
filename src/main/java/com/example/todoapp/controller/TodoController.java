package com.example.todoapp.controller;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;

public class TodoController {
    private final TodoRepository todoRepository;

    // Constructor to accept TodoRepository
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Method to display all todos
    public void displayAllTodos() {
        List<Todo> todos = todoRepository.getAllTodos();
        if (todos.isEmpty()) {
            System.out.println("No todos found.");
        } else {
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    // Method to create a new todo
    public void createTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Todo newTodo = new Todo();
        newTodo.setTitle(title);
        newTodo.setDescription(description);
        todoRepository.createTodo(newTodo);
        System.out.println("Todo created successfully.");
    }

    // Method to update an existing todo
    public void updateTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter todo ID to update: ");
        Long id = Long.parseLong(scanner.nextLine());

        Todo todoToUpdate = todoRepository.getAllTodos().stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (todoToUpdate == null) {
            System.out.println("Todo not found.");
            return;
        }

        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description (leave blank to keep current): ");
        String newDescription = scanner.nextLine();
        System.out.print("Is it completed? (true/false): ");
        boolean isCompleted = Boolean.parseBoolean(scanner.nextLine());

        if (!newTitle.isEmpty()) {
            todoToUpdate.setTitle(newTitle);
        }
        if (!newDescription.isEmpty()) {
            todoToUpdate.setDescription(newDescription);
        }
        todoToUpdate.setCompleted(isCompleted);

        todoRepository.updateTodo(todoToUpdate);
        System.out.println("Todo updated successfully.");
    }

    // Method to delete a todo
    public void deleteTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter todo ID to delete: ");
        Long id = Long.parseLong(scanner.nextLine());
        todoRepository.deleteTodo(id);
        System.out.println("Todo deleted successfully.");
    }
}
