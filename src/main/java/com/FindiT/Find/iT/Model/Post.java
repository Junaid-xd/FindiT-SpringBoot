

package com.FindiT.Find.iT.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer postID;

    private String productName;
    private Integer status;
    private String location;
    //private Integer userID;

    @Column(name="date", nullable = false, updatable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Column(length = 1000)
    private String description;

    private String imgPath;


    @ManyToOne
    @JoinColumn(name = "fk_user_ID")
    // @JsonBackReference
    private Users user;

    public Post() {

    }

    public Post(String productName, Integer postID, Integer status, String location, Integer userID, LocalDateTime date, String description, String imgPath, Users user) {
        this.productName = productName;
        this.postID = postID;
        this.status = status;
        this.location = location;
        //this.userID = userID;
        this.date = date;
        this.description = description;
        this.imgPath = imgPath;
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

//    public Integer getUserID() {
//        return userID;
//    }
//
//    public void setUserID(Integer userID) {
//        this.userID = userID;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

























