package com.andre.taskmanagement.task.controller;

import com.andre.taskmanagement.task.dto.TaskListRequest;
import com.andre.taskmanagement.task.dto.TaskListResponse;
import com.andre.taskmanagement.task.service.TaskListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskListResponse create(@RequestBody @Valid TaskListRequest request) {
        return TaskListResponse.from(
                taskListService.create(request.title())
        );
    }

    @GetMapping
    public List<TaskListResponse> findAll() {
        return taskListService.findAll()
                .stream()
                .map(TaskListResponse::from)
                .toList();
    }

    @PutMapping("/{id}")
    public TaskListResponse update(
            @PathVariable Long id,
            @RequestBody @Valid TaskListRequest request
    ) {
        return TaskListResponse.from(
                taskListService.update(id, request.title())
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskListService.delete(id);
    }
}
