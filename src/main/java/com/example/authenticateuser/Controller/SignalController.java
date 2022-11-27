package com.example.authenticateuser.Controller;

import com.example.authenticateuser.Entity.Signal;
import com.example.authenticateuser.Service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/signal")
public class SignalController {
    public String getvisualization()   {
        String command = "python vis.py";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
        BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line;
        while ((line = bri.readLine()) != null) {
            System.out.println(line);
        }
        bri.close();
        while ((line = bre.readLine()) != null) {
            System.out.println(line);
        }
        bre.close();
        p.waitFor();
        System.out.println("Done.");

        p.destroy();
    }

    @Autowired
    SignalService signalService;

    ArrayList<Signal> arrayList = new ArrayList<>();

//    @GetMapping("/123")
//    public int test(){
//        System.out.println("enter");
//        return 3;
//    }

    @PostMapping("/save")
    public Signal save(@RequestBody Signal signal){
        arrayList.add(signal);
        System.out.println(signal.toString() +"||" +arrayList.size());
        String data = signal.collectData();
        try {
            FileOutputStream fos = new FileOutputStream("test.csv",true);
            fos.write(data.getBytes());
            fos.write(System.getProperty("line.separator").getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signal;
    }

    @GetMapping("/ditection")
    public int ditection(){
        //TODO compute results for the input
        double avg=0.0;
//        getvisualization();
        for (Signal s:arrayList) {
            avg+=s.getFinger_tapping();}
        if (avg/arrayList.size()>0){
        return 1;
        }
        return -1;
        arrayList.clear();
        return 0;
    }


}
