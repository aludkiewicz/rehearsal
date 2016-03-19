package com.hicollege.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ui", method = RequestMethod.GET)
public class UiController {
    
    @ResponseBody
    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
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
