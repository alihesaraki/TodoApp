# Todo List Application

This is a simple Todo List application built using Java and Hibernate ORM. It allows users to create, read, update, and delete (CRUD) todo tasks, all of which are stored in an Oracle database using Hibernate for ORM (Object Relational Mapping).

## Features

- **Display All Todos**: View a list of all the current todos.
- **Create Todo**: Add a new todo task with a title and description.
- **Update Todo**: Modify the title, description, and completion status of an existing todo.
- **Delete Todo**: Remove a todo task by its ID.
- **Persistence**: All tasks are persisted in an Oracle database using Hibernate ORM.

## Project Structure

The project is divided into several packages:

- **com.example.todoapp.model**: Contains the `Todo` entity, which represents a todo task.
- **com.example.todoapp.repository**: Contains the `TodoRepository` class that handles database interactions.
- **com.example.todoapp.controller**: Contains the `TodoController` class that manages user interactions and business logic.
- **com.example.todoapp.main**: Contains the `Main` class, which is the entry point of the application.
