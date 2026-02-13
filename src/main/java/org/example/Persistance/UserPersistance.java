package org.example.Persistance;

import org.example.Observer.User;

public interface UserPersistance {
    void saveUser(User user);

    User getUser(String userId);
}
