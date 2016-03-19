package com.hicollege.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hicollege.webapp.dtos.User;

@RestController
@RequestMapping(value = "/add", method = RequestMethod.PUT)
public class CreationController {
    
    @Autowired
    private Dao dao;
    
    @RequestMapping(value = "/user")
    public void addUser(
        @RequestParam(value = "username", required = true) String username,
        @RequestParam(value = "email",    required = true) String email,
        @RequestParam(value = "age",      required = true) int age) {
        
        User newUser = new User(username, email, Integer.toString(age));
        dao.saveUser(newUser);
        
    }

}
