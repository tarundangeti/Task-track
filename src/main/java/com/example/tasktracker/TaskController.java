package com.example.tasktracker;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(
  origins = "*",
  allowedHeaders = "*",
  methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}
)
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        if (task.getId() == null || task.getId().isEmpty()) {
            task.setId(UUID.randomUUID().toString());
        }
        tasks.add(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
