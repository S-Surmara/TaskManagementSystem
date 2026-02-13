package org.example;

import org.example.Entity.Task;
import org.example.Entity.UpdateTaskRequest;
import org.example.Persistance.TaskPersistance;
import org.example.Observer.User;
import org.example.Persistance.UserPersistance;
import org.example.Stratergy.SortStratergy;

import java.time.LocalDate;
import java.util.List;

public class TaskController {
    TaskPersistance taskPersistance;
    UserPersistance userPersistance;

    SortStratergy sortStratergy;
    TaskManager taskManager;

    public TaskController(TaskPersistance taskPersistance, UserPersistance userPersistance, TaskManager taskManager,SortStratergy sortStratergy){
        this.taskPersistance = taskPersistance;
        this.userPersistance = userPersistance;
        this.taskManager = taskManager;
        this.sortStratergy = sortStratergy;
    }
    public void assignTask(String taskId,String userId){
        taskPersistance.saveUserTask(taskId,userId);
        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
        User assignee = userPersistance.getUser(userId);
        updateTaskRequest.setAssignee(assignee);
        taskManager.updateTask(taskId,updateTaskRequest);
    }

    public void setReminder(String taskId, LocalDate date){
        taskPersistance.getTask(taskId).setDuedate(date);
    }

    public List<Task> getSortedTaskList(){
        return sortStratergy.getSortTask(taskPersistance.getAllTask());
    }

}
