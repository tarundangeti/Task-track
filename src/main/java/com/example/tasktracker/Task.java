package com.example.tasktracker;

import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private boolean done;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Task(String title, boolean done) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.done = done;
    }

    // Getters and Setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean isDone() { return done; }

    public void setDone(boolean done) { this.done = done; }
}
