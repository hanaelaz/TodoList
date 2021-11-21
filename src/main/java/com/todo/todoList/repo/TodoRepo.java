package com.todo.todoList.repo;

import com.todo.todoList.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoItem, Integer> {

}
