package com.hicollege.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hicollege.webapp.dtos.Album;
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
        @RequestParam(value = "age",      required = true) int age,
        @RequestParam(value = "albums",   required = false) List<String> albums) {
        
        User newUser = new User(username, email, Integer.toString(age));
        if(albums != null) {
            for(String title : albums) {
                Album album = dao.findAlbumByTitle(title);
                newUser.getAlbums().add(album);
            }
        }
        
        dao.saveUser(newUser);
    }
    
    @RequestMapping(value = "/album")
    public void addAlbum(
        @RequestParam(value = "title", required = true) String title,
        @RequestParam(value = "artists", required = true) List<String> artists,
        @RequestParam(value = "songs", required = true) List<String> songs) {
        
        Album album = new Album();
        album.setTitle(title);
        album.setSongs(songs);
        album.setArtists(artists);
        
        dao.saveAlbum(album);
        
    }

}
