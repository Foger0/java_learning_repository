package com.java.demo;

import com.java.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService3 {
    @Autowired
    private User user2;
    public void sayHi(){
        System.out.println(user2.getUsername());
    }
}
