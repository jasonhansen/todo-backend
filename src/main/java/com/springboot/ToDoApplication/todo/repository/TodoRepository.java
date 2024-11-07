package com.springboot.ToDoApplication.todo.repository;

import com.springboot.ToDoApplication.todo.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {

   List<ToDo> findByUsername(String username);
}
