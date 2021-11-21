package com.todo.todoList.controller;

import com.sun.istack.NotNull;
import com.todo.todoList.model.TodoItem;
import com.todo.todoList.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoRepo todoRepo;
    @GetMapping(value ="/")
    public ModelAndView getAllItems (Model model ) {
        List<TodoItem> todoItemList=(List<TodoItem>) todoRepo.findAll();
        ModelAndView modelAndView = new ModelAndView ( );
        model.addAttribute("todoItemList",todoItemList);
        modelAndView.setViewName ( "index" );
        return modelAndView;
    }


    @PutMapping(value ="/edit/{id}")
    public void editState(@PathVariable int id){
        List<TodoItem> todoItemList=(List<TodoItem>) todoRepo.findAll();
    for(TodoItem item : todoItemList )
        if(item.getId()==id ){
            if (item.isStatue()){
                item.setStatue(false);
            }else{
                item.setStatue(true);
            }
            todoRepo.save(item);
        }

    }

    @PostMapping(value ="/add")
    public void save(@Validated @NotNull @ModelAttribute("todoIdItem") TodoItem todoItem, HttpServletResponse response) throws IOException {
        todoRepo.save(todoItem);
        response.sendRedirect("/");


    }

    @RequestMapping(value ="/getByID/{id}")
    public ModelAndView getByID(@PathVariable int id,Model model){

        TodoItem todoIdItem = todoRepo.getById(id);
        ModelAndView modelAndView = new ModelAndView ( );
        model.addAttribute("todoIdItem",todoIdItem);
        modelAndView.setViewName ( "popUp" );

        return modelAndView;
    }



}
