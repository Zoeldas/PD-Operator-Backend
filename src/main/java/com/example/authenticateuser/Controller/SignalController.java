package com.example.authenticateuser.Controller;

import com.example.authenticateuser.Entity.Signal;
import com.example.authenticateuser.Service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/signal")
public class SignalController {
    @Autowired
    SignalService signalService;

    ArrayList<Signal> arrayList = new ArrayList<>();

    @PostMapping("/save")
    public Signal saveSignal(@RequestBody Signal signal){
        arrayList.add(signal);

//        signalService.save(signal);

        return signal;
    }

    @GetMapping("/ditection")
    public int ditection(){
        //TODO compute results for the input
        for (Signal s:arrayList
             ) {
            System.out.print(s.toString());
        }
        arrayList.clear();
        return 0;
    }


}
