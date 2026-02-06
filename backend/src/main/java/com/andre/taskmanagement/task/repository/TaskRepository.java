package com.andre.taskmanagement.task.repository;

import com.andre.taskmanagement.task.entity.Task;
import com.andre.taskmanagement.task.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskList(TaskList taskList);

    List<Task> findByCompleted(boolean completed);
}
