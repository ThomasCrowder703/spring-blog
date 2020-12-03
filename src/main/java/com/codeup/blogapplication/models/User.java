package com.codeup.blogapplication.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length =100, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(long id, String email, String username, String password){
        this.id = id;
        this. email = email;
        this.username = username;
        this.password = password;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }


}
