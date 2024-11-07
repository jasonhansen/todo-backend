package com.springboot.ToDoApplication.todo;

import com.springboot.ToDoApplication.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpa {

    private ToDoService toDoService;

    private TodoRepository todoRepository;

    public TodoJpa(ToDoService toDoService, TodoRepository todoRepository) {
        this.toDoService = toDoService;
        this.todoRepository = todoRepository;
    }
    @GetMapping("/users/{username}/todos")
    public List<ToDo> retrieveTodos(@PathVariable String username) {
//        return toDoService.findByUsername(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo retrieveTodo(@PathVariable String username, @PathVariable int id) {
//        return toDoService.findById(id);
        return todoRepository.findById(id).get();
    }

    @DeleteMapping ("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
//        toDoService.deleteById(id);
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ToDo updateTodo(@PathVariable String username, @PathVariable int id,@RequestBody ToDo toDo) {
//        toDoService.updateTodo(toDo);
        todoRepository.save(toDo);
        return toDo;
    }

    @PostMapping ("/users/{username}/todos")
    public ToDo createTodo(@PathVariable String username, @RequestBody ToDo toDo) {
        toDo.setUsername(username);
        toDo.setId(null);
        return todoRepository.save(toDo);
//        ToDo createdTodo =  toDoService.addTodo(username, toDo.getDescription(), toDo.getTargetDate(), toDo.isDone());
        
//        return createdTodo;
    }

}
