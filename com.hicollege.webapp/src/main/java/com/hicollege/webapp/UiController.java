package com.hicollege.webapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hicollege.webapp.dtos.User;

@Controller
@RequestMapping(value = "/ui", method = RequestMethod.GET)
public class UiController {
    
    @ResponseBody
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public List<User> hello() {
        
        List<User> users = Arrays.asList(new User("Alex", "a@b.c", "28"), new User("Alex", "a@b.c", "28"), new User("Alex", "a@b.c", "28"));
        
        return users;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String ui() {
        return "ui/ui";
    }
    
    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String uiAlbums() {
        return "ui/ui_album";
    }
}
