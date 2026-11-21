package ru.netology.ToDoList;

public class Task {
    private int id;
    private String title;
    private boolean completed;
    private String createdAt;

    public Task(int id, String title, boolean completed, String createdAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public int getID() {
        return id;
    }
}
