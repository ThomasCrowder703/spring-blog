package com.codeup.blogapplication.models;

import javax.persistence.*;

@Entity
@Table(name ="posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @OneToOne
    private User owner;

    public Posts(){}

    public Posts(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Posts(Long id, String title,String body, User owner){
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body){
        this.body = body;
    }

    public User getOwner(){
        return this.owner;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }
}
