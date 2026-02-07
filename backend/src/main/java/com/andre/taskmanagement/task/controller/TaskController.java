package com.andre.taskmanagement.task.controller;

import com.andre.taskmanagement.task.dto.TaskRequest;
import com.andre.taskmanagement.task.dto.TaskResponse;
import com.andre.taskmanagement.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-lists/{taskListId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(
            @PathVariable Long taskListId,
            @RequestBody @Valid TaskRequest request
    ) {
        return TaskResponse.from(
                taskService.create(taskListId, request.title(), request.description())
        );
    }

    @GetMapping
    public List<TaskResponse> findAll(@PathVariable Long taskListId) {
        return taskService.findByTaskList(taskListId)
                .stream()
                .map(TaskResponse::from)
                .toList();
    }

    @PutMapping("/{taskId}")
    public TaskResponse update(
            @PathVariable Long taskId,
            @RequestBody @Valid TaskRequest request
    ) {
        return TaskResponse.from(
                taskService.update(taskId, request.title(), request.description())
        );
    }

    @PatchMapping("/{taskId}/complete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable Long taskId) {
        taskService.complete(taskId);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }
}
