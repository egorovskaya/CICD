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

    public String getTitle() {
        return title;
    }

    public boolean getIsCompleted() {
        return completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
