package org.example.Persistance;

import org.example.Observer.User;

import java.util.HashMap;
import java.util.Map;

public class inMemoryUser implements UserPersistance{

    Map<String, User> userMap;

    public inMemoryUser(){
        userMap = new HashMap<>();
    }
    public void saveUser(User user) {
        userMap.put(user.getUserId(),user);
    }

    public User getUser(String userId){
        return userMap.get(userId);
    }
}
