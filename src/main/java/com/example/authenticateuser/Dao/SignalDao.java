package com.example.authenticateuser.Dao;



import org.springframework.data.jpa.repository.Query;
import com.example.authenticateuser.Entity.Signal;
import org.springframework.data.repository.CrudRepository;

public interface SignalDao extends CrudRepository<Signal,String> {

}
