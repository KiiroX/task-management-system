-- Initial setup script for Task Management App
-- Author: Andre

CREATE DATABASE IF NOT EXISTS taskdb
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE taskdb;

CREATE TABLE IF NOT EXISTS task_lists (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_list_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed TINYINT(1) NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_tasks_task_list
        FOREIGN KEY (task_list_id)
        REFERENCES task_lists(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_tasks_task_list_id ON tasks(task_list_id);
