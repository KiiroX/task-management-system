package com.andre.taskmanagement.task.repository;

import com.andre.taskmanagement.task.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}
