package com.andre.taskmanagement.task.dto;

import com.andre.taskmanagement.task.entity.TaskList;

public record TaskListResponse(Long id, String title) {

    public static TaskListResponse from(TaskList taskList) {
        return new TaskListResponse(
                taskList.getId(),
                taskList.getTitle()
        );
    }
}
