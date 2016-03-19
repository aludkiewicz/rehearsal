package com.hicollege.webapp.dtos;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class User {
    
    private int id;


    private String name;
    private String email;
    private String age;
    
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
    
    
    
    

}
