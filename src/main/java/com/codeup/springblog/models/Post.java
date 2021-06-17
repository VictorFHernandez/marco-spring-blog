package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User owner;

    public Post(){}

    public Post(String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(long id, String title, String body, User owner){
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getBody(){
        return this.body;
    }
    public void setBody(String body){
        this.body = body;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
