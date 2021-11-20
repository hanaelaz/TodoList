package com.todo.todoList.controller;

import com.todo.todoList.model.TodoItem;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @GetMapping(value ="/")
    public ModelAndView getAllItems (Model model ) {
        TodoItem A1=new TodoItem(1,"todo1",false);
        TodoItem A2=new TodoItem(1,"todo2",true);
        TodoItem A3=new TodoItem(1,"todo3",false);
        List<TodoItem> todoItemList= new ArrayList<TodoItem>();
        todoItemList.add(A1);
        todoItemList.add(A2);
        todoItemList.add(A3);
        ModelAndView modelAndView = new ModelAndView ( );
        model.addAttribute("todoItemList",todoItemList);
        modelAndView.setViewName ( "index" );
        return modelAndView;
    }


}
