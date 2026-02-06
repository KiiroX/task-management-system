package com.andre.taskmanagement.task.service;

import com.andre.taskmanagement.task.entity.TaskList;
import com.andre.taskmanagement.task.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskList> findAll() {
        return taskListRepository.findAll();
    }

    public TaskList findById(Long id) {
        return taskListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TaskList not found"));
    }

    public TaskList create(String title) {
        TaskList taskList = new TaskList(title);
        return taskListRepository.save(taskList);
    }

    public TaskList update(Long id, String title) {
        TaskList taskList = findById(id);
        taskList.setTitle(title);
        return taskListRepository.save(taskList);
    }

    public void delete(Long id) {
        taskListRepository.deleteById(id);
    }
}
