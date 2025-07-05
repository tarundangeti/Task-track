package com.example.tasktracker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin // allows frontend on different origin (like file:// or localhost:3000)
public class TaskController {

    // In-memory list (no DB)
    private final List<Task> tasks = new ArrayList<>();

    // GET /api/tasks
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // POST /api/tasks
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        if (task.getId() == null || task.getId().isEmpty()) {
            task.setId(UUID.randomUUID().toString());
        }
        tasks.add(task);
        return task;
    }

    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
