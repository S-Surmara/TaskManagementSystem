package org.example.Persistance;

import org.example.Entity.Task;

import java.util.List;

public interface TaskPersistance {

    List<Task> getAllTask();
    void saveTask(Task task);
    Task getTask(String taskId);

    void deleteTask(String taskId);

    void saveUserTask(String taskId,String userId);

    List<String> getUserTask(String userId);

    void deleteUserTask(String taskId,String userId);
}
