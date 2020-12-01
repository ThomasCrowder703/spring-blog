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

    public Posts(){}

    public Posts(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle(){
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body){
        this.body = body;
    }
}
