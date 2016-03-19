package com.hicollege.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hicollege.webapp.dtos.Album;
import com.hicollege.webapp.dtos.User;

@RestController
@RequestMapping(value = "/find", method = RequestMethod.GET)
public class SearchController {
    
    @Autowired
    private Dao dao;
    
    
    @RequestMapping(value = "/allusers")
    public List<User> findAllUsers() {
        return dao.getAllUsers();
    }
    
    @RequestMapping(value = "/allalbums")
    public List<Album> findAllAlbums() {
        return dao.getAllAlbums();
    }

}
