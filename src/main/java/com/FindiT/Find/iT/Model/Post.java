




package com.FindiT.Find.iT.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // It ensures that there would be a single table in database
public abstract class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer postID;

    private String productName;
    private Integer status;
    private String location;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "fk_user_ID")
    private Users user;

    public Post() {
    }

    public Post(String productName, Integer status, String location, Users user) {
        this.productName = productName;
        this.status = status;
        this.location = location;
        this.user = user;
    }

    // Getters and Setters
    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

