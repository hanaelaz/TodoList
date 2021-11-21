package com.todo.todoList.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem {

    private int id;
    @NotNull
    private String titre;
    private boolean statue;

    public TodoItem() {
    }

    public TodoItem(int id, String titre, boolean statue) {
        this.id = id;
        this.titre = titre;
        this.statue = statue;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isStatue() {
        return statue;
    }

    public void setStatue(boolean statue) {
        this.statue = statue;
    }

}
