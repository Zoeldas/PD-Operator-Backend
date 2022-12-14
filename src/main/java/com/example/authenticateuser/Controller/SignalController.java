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
//    public String getvisualization()   {
//        String command = "python vis.py";
//        Process p = Runtime.getRuntime().exec(command);
//        p.waitFor();
//        BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//        String line;
//        while ((line = bri.readLine()) != null) {
//            System.out.println(line);
//        }
//        bri.close();
//        while ((line = bre.readLine()) != null) {
//            System.out.println(line);
//        }
//        bre.close();
//        p.waitFor();
//        System.out.println("Done.");
//
//        p.destroy();
//    }

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
        signal.setSignal_id((arrayList.size()+1) % 20);
        arrayList.add(signal);
        System.out.println(signal.toString()+ "||" + signal.getSignal_id() +"||" +arrayList.size());
        String data = signal.collectData();
//        try {
//            FileOutputStream fos = new FileOutputStream("test.csv",true);
//            fos.write(data.getBytes());
//            fos.write(System.getProperty("line.separator").getBytes());
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return signal;
    }

    @GetMapping("/ditection")
    public int ditection(){
        //TODO compute results for the input
        double avg = 0.0;
        int size = 0;
        System.out.println("ditection called");
//        getvisualization();
        for (Signal s:arrayList) {
            if (s.getFinger_tapping() > 0) {
                avg += s.getFinger_tapping();
                size += 1;
            }
        }
        arrayList.clear();
        double result = avg/size;
        System.out.println(result);
        if (result>0.1){
        return 1;
        }
        return -1;

//        return 0;
    }


}
