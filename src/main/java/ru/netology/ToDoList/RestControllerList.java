package ru.netology.ToDoList;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        listTask.add(new Task(task.getID(), task.getTitle(), task.getIsCompleted(), task.getCreatedAt()));
        return task;
    }

    @PutMapping("/{id}")
    public void editById(@PathVariable int id, @RequestBody Task task) {
        Optional<Task> optionalTask = listTask.stream()
                .filter(t -> t.getID() == id)
                .findFirst();


        Task updatingTask = optionalTask.get();

        updatingTask.setId(task.getID());
        updatingTask.setTitle(task.getTitle());
        updatingTask.setCompleted(task.getIsCompleted());
        updatingTask.setCreatedAt(task.getCreatedAt());
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        listTask.removeIf(task -> task.getID() == id);
    }
}
