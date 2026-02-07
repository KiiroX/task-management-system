package com.andre.taskmanagement.task.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskListRequest(@NotBlank String title) {
}
