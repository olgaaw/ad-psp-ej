package com.salesianos.spring_security.controller;

import com.salesianos.spring_security.model.Task;
import com.salesianos.spring_security.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.findAll();
    }


    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task nuevo) {
        Task task = taskService.save(nuevo);
        return ResponseEntity.status(201).body(nuevo);
    }

}
