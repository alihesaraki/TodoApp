package com.example.todoapp.main;

import com.example.todoapp.controller.TodoController;
import com.example.todoapp.repository.TodoRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // راه‌اندازی Hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // فایل پیکربندی Hibernate
                .buildSessionFactory();

        // ایجاد ریپازیتوری و کنترلر
        TodoRepository todoRepository = new TodoRepository(sessionFactory);
        TodoController todoController = new TodoController(todoRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Todo Application ===");
            System.out.println("1. Display All Todos");
            System.out.println("2. Create Todo");
            System.out.println("3. Update Todo");
            System.out.println("4. Delete Todo");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    todoController.displayAllTodos();
                    break;
                case 2:
                    todoController.createTodo();
                    break;
                case 3:
                    todoController.updateTodo();
                    break;
                case 4:
                    todoController.deleteTodo();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    sessionFactory.close(); // بستن SessionFactory
                    return; // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
