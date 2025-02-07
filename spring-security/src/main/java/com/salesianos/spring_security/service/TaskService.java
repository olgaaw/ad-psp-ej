package com.salesianos.spring_security.service;

import com.salesianos.spring_security.model.Task;
import com.salesianos.spring_security.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            throw new RuntimeException("No existen tasks con esos criterios de búsqueda");
        }
        return tasks;

    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe task con el id "+id));
    }

    public Task save(Task task) {
        Task task1 = Task.builder()
                .title(task.getTitle())
                .build();

        return taskRepository.save(task1);
    }


}
