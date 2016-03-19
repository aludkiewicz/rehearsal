package com.hicollege.webapp.dtos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    
    private int album_id;
    private String title;
    private List<String> songs;
    private List<String> artists;
    
    @Id
    @GeneratedValue
    @Column(name = "album_id")
    public int getAlbum_id() {
        return album_id;
    }
    
    
    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }
    
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "songs", joinColumns = @JoinColumn(name = "album_id"))
    @Column(name = "songs")
    public List<String> getSongs() {
        return songs;
    }
    
    
    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "artists", joinColumns = @JoinColumn(name = "album_id"))
    @Column(name = "artists")
    public List<String> getArtists() {
        return artists;
    }
    
    
    public void setArtists(List<String> artists) {
        this.artists = artists;
    }
}
