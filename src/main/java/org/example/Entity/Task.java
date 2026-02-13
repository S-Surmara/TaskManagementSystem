package org.example.Entity;

import org.example.ENUM.Priority;
import org.example.Observer.TaskObserver;
import org.example.Observer.User;
import org.example.State.PendingState;
import org.example.State.TaskState;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Task {
    String id;
    String title;
    String description;
    LocalDate duedate;
    Priority priority;
    TaskState taskState;
    Set<TaskObserver> taskObserversList;
    User assigned;
    User assginee;

    private Task(String title , String description,LocalDate duedate, Priority priority,User assigned, User assignee){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.duedate = duedate;
        this.priority = priority;
        this.assginee = assignee;
        this.assigned = assigned;
        this.taskState = new PendingState();
        this.taskObserversList = new HashSet<>();
        this.addObserver(assigned);
        this.addObserver(assignee);
    }

    public static class Builder {
        String title;
        String description;
        LocalDate dueDate;
        Priority priority;
        User assigned;
        User assignee;

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withDueDate(LocalDate dueDate){
            this.dueDate = dueDate;
            return this;
        }

        public Builder withPriotity(Priority priority){
            this.priority = priority;
            return this;
        }

        public Builder withAssigned(User assigned){
            this.assigned = assigned;
            return this;
        }

        public Builder withAssignee(User assignee){
            this.assignee = assignee;
            return this;
        }

        public Task build(){
            return new Task(this.title,this.description,this.dueDate,this.priority,this.assigned,this.assignee);
        }

    }

    public String getId(){
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate(){
        return this.duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setAssignee(User assignee){
        taskObserversList.remove(this.assginee);
        this.assginee = assignee;
        taskObserversList.add(this.assginee);
    }

    public  void setAssigned(User assigned){
        taskObserversList.remove(this.assigned);
        this.assigned = assigned;
        taskObserversList.add(this.assigned);
    }

    public void removeObserver(TaskObserver observer){
        taskObserversList.remove(observer);
    }

    public void setTaskState(TaskState taskState){
        this.taskState = taskState;
    }

    public void addObserver(TaskObserver taskObserver){
        taskObserversList.add(taskObserver);
    }

    public void notifyObservers(){
        taskObserversList.forEach((observer) -> observer.notify(this.id));
    }
}
