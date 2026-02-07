package com.andre.taskmanagement.task.service;

import com.andre.taskmanagement.task.entity.Task;
import com.andre.taskmanagement.task.entity.TaskList;
import com.andre.taskmanagement.task.exception.TaskNotFoundException;
import com.andre.taskmanagement.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskListService taskListService;

    public TaskService(TaskRepository taskRepository, TaskListService taskListService) {
        this.taskRepository = taskRepository;
        this.taskListService = taskListService;
    }

    public List<Task> findByTaskList(Long taskListId) {
        TaskList taskList = taskListService.findById(taskListId);
        return taskRepository.findByTaskList(taskList);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(Long taskListId, String title, String description) {
        TaskList taskList = taskListService.findById(taskListId);
        Task task = new Task(taskList, title, description);
        return taskRepository.save(task);
    }

    public Task update(Long id, String title, String description) {
        Task task = findById(id);
        task.setTitle(title);
        task.setDescription(description);
        return taskRepository.save(task);
    }

    public void complete(Long id) {
        Task task = findById(id);
        task.markCompleted();
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
