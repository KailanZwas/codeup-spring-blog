package com.codeup.codeupspringblog.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String userName;
    @Column(nullable = false, length = 60)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Post> posts;

    public User() {
    }


    public User(Long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        userName = copy.userName;
        password = copy.password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(List<Post> posts) {
        this.posts = posts;
    }
}
