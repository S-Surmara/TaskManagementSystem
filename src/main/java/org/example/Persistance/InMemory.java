package org.example.Persistance;

import org.example.Entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemory implements TaskPersistance{
    Map<String,Task> taskList;
    Map<String, List<String>> userTaskList;

    public InMemory(){
        this.taskList = new HashMap<>();
        this.userTaskList = new HashMap<>();
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> task = new ArrayList<>();
        taskList.forEach((key,value) -> task.add(value));
        return task;
    }
    @Override
    public void saveTask(Task task){
        taskList.put(task.getId(),task);
    }

    @Override
    public Task getTask(String taskId) {
        return taskList.get(taskId);
    }

    @Override
    public void deleteTask(String taskId){
        taskList.remove(taskId);
    }

    @Override
    public void saveUserTask(String taskId,String userId){
        if (!userTaskList.containsKey(userId)) {
            userTaskList.put(userId, new ArrayList<>());
        }

        userTaskList.get(userId).add(taskId);
    }

    @Override
    public List<String> getUserTask(String userId){
        return userTaskList.get(userId);
    }

    @Override
    public void deleteUserTask(String taskId, String userId) {
        if (!userTaskList.containsKey(userId)) {
            return;
        }
        List<String> taskList = userTaskList.get(userId);
        taskList.remove(taskId);
        if (taskList.isEmpty()) {
            userTaskList.remove(userId);
        }
    }

}
