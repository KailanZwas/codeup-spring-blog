package com.codeup.codeupspringblog.model;

public class Post {
    private String title;
    private String body;

    /// Constructor

public Post (){

}
    public Post(String title) {
        this.title = title;
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    // Getters Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
