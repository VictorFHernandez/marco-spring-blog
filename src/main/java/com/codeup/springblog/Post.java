package com.codeup.springblog;

public class Post {
    private String title;
    private String body;

    public Post(){}

    public Post(String title, String body){
        this.title = title;
        this.body = body;
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
}
