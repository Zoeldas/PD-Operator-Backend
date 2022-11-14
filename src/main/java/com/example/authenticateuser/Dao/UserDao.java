package com.example.authenticateuser.Dao;
import com.example.authenticateuser.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,String> {
}