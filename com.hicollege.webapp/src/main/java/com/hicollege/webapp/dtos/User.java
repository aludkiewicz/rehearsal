package com.hicollege.webapp.dtos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class User {
    
    private int id;


    private String name;
    private String email;
    private String age;
    
    private Set<Album> albums = new HashSet<>();
    
    public User() {}
    
    
    public User(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "name")
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "age")
    public String getAge() {
        return age;
    }
    
    
    public void setAge(String age) {
        this.age = age;
    }
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_album_join", catalog = "hicollege", joinColumns = {
    @JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
    inverseJoinColumns = {@JoinColumn(name = "album_id", nullable = false, updatable = false) })
    public Set<Album> getAlbums() {
        return albums;
    }


    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((albums == null) ? 0 : albums.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User)obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (albums == null) {
            if (other.albums != null)
                return false;
        } else if (!albums.equals(other.albums))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
