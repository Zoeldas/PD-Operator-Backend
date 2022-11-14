package com.example.authenticateuser.Service;

import com.example.authenticateuser.Entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    public User getUser(User user);

    public User insertIntoDatabase(User user);
}