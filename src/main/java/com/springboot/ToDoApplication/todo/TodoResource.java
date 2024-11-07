package com.springboot.ToDoApplication.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class TodoResource {

    private ToDoService toDoService;

    public TodoResource(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @GetMapping("/users/{username}/todos")
    public List<ToDo> retrieveTodos(@PathVariable String username) {
        return toDoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo retrieveTodo(@PathVariable String username, @PathVariable int id) {
        return toDoService.findById(id);
    }

    @DeleteMapping ("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        toDoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ToDo updateTodo(@PathVariable String username, @PathVariable int id,@RequestBody ToDo toDo) {
        toDoService.updateTodo(toDo);
        return toDo;
    }

    @PostMapping ("/users/{username}/todos")
    public ToDo createTodo(@PathVariable String username, @RequestBody ToDo toDo) {
        ToDo createdTodo =  toDoService.addTodo(username, toDo.getDescription(), toDo.getTargetDate(), toDo.isDone());
        
        return createdTodo;
    }

}
