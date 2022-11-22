package com.example.authenticateuser.Controller;

import com.example.authenticateuser.Entity.Signal;
import com.example.authenticateuser.Entity.User;
import com.example.authenticateuser.Service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("/123")
//    public int test(){
//        System.out.println("enter");
//        return 3;
//    }

    @PostMapping("/getUser")
    public User getUser(@RequestBody User user) {
        return userService.getUser(user);
    }

    @PutMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.insertIntoDatabase(user);
    }

//    // generate salt, default is 16 digits
//    String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//    // set hash iterates times
//    int times = 2;
//    // get hashed password
//    String encodedPassword = new SimpleHash("md5", User.getPassword(), salt, times).toString();
//    // 存储用户信息，包括 salt 与 hash 后的密码

}
