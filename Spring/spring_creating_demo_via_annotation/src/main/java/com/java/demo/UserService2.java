package com.java.demo;

import com.java.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {
   @Bean(name = "user1")
    public User getUserbyName(){
       User user=new User();
       user.setUid(1);
       user.setUsername("hangman");
       user.setPassword("123");
       return user;
   }


}
