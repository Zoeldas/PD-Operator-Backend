package com.example.authenticateuser.Service;

import com.example.authenticateuser.Dao.SignalDao;
import com.example.authenticateuser.Entity.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalService {

    @Autowired
    SignalDao signalDao;

    public Signal save(Signal signal){
        return  signalDao.save(signal);
    }
}
