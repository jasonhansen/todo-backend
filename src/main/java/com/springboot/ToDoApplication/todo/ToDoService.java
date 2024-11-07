package com.springboot.ToDoApplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new ToDo(++todosCount, "test1234","Learn Spring Framework", LocalDate.now().plusYears(10),false));
        todos.add(new ToDo(++todosCount, "test1234","Get DevOps Certification", LocalDate.now().plusYears(10),false));
        todos.add(new ToDo(++todosCount, "test1234","Master Spring boot 3 & Spring boot 6", LocalDate.now().plusYears(10),false));
    }

    public List<ToDo> findByUsername(String username) {
        Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public ToDo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo todo = new ToDo(++todosCount, username,description,targetDate,done);
        todos.add(todo);
        return todo;
    }

    public void deleteById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(ToDo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

}
