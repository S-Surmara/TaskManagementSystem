package org.example.Observer;

public class AuditObserver implements TaskObserver{
    @Override
    public void notify(String taskId){
        System.out.println("Task with id: " + taskId + " is done");
    }
}
