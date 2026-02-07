package com.andre.taskmanagement.task.exception;

public class TaskListNotFoundException extends RuntimeException {
    public TaskListNotFoundException(Long id) {
        super("TaskList not found with id " + id);
    }
}
