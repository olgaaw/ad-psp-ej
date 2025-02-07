package com.salesianos.spring_security.repository;

import com.salesianos.spring_security.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
