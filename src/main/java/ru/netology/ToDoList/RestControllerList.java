package ru.netology.ToDoList;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class RestControllerList {
    List<Task> listTask = new ArrayList<>();

    @GetMapping
    public List<Task> all() {
        return listTask.stream().toList();
    }

    @PostMapping
    public Task add(@RequestBody Task task) {
        listTask.add(task);
        return task;
    }

    @PutMapping("/{id}")
    public void editById(@PathVariable int id, @RequestBody Task task) {
        listTask.set(id, task);


    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        listTask.remove(id);
    }
}
