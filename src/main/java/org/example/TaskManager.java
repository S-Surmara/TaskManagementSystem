package org.example;

import org.example.ENUM.Priority;
import org.example.Entity.Task;
import org.example.Entity.UpdateTaskRequest;
import org.example.Observer.User;
import org.example.Persistance.TaskPersistance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TaskManager {

    TaskPersistance taskPersistance;

    public TaskManager(TaskPersistance taskPersistance){
        this.taskPersistance = taskPersistance;
    }
    void createTask(String title , String description,LocalDate duedate, Priority priority,User assigned){
        Task task = new Task.Builder()
                .withTitle("Fix Login Bug")
                .withDescription("Resolve null pointer in login flow")
                .withDueDate(LocalDate.now())
                .withPriotity(Priority.HIGH)
                .withAssigned(assigned)
                .withAssignee(assigned)
                .build();
        taskPersistance.saveTask(task);
    }

    void updateTask(String taskId, UpdateTaskRequest request) {

        Task task = taskPersistance.getTask(taskId);

        if (request.getTitle() != null) {
            task.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }

        if (request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }

        if (request.getAssignee() != null) {
            task.setAssignee(request.getAssignee());
        }

        if(request.getAssigned() != null) {
            task.setAssigned(request.getAssigned());
        }

        taskPersistance.saveTask(task);
    }

    public void deleteTask(String taskId){
        taskPersistance.deleteTask(taskId);
    }


}
