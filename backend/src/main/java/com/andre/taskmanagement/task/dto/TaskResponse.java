package com.andre.taskmanagement.task.dto;

import com.andre.taskmanagement.task.entity.Task;

public record TaskResponse(Long id, String title, String description, boolean completed) {

    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }
}
