package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TodoRepository {
    private final SessionFactory sessionFactory;

    // Constructor to accept SessionFactory
    public TodoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Retrieve all todos using a raw SQL query
    public List<Todo> getAllTodos() {
        try (Session session = sessionFactory.openSession()) {
            String sql = "SELECT * FROM todos"; // SQL query
            return session.createNativeQuery(sql, Todo.class).getResultList();
        }
    }

    // Method to create a new todo
    public void createTodo(Todo todo) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Method to update an existing todo
    public void updateTodo(Todo todo) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Method to delete a todo
    public void deleteTodo(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Todo todo = session.get(Todo.class, id);
            if (todo != null) {
                session.delete(todo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
