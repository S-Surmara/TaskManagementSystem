package org.example.Observer;

import java.util.Map;
import java.util.UUID;

public class User implements TaskObserver{

    String userId;
    String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.userId = UUID.randomUUID().toString();
        this.name = name;
    }
    @Override
    public void notify(String taskId){
        System.out.println("Task with id: " + taskId + "is done");
    }
}
