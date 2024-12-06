package com.FindiT.Find.iT.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postID;

    @Column(name = "userID", insertable = false, updatable = false) // Optional if you want to map it for non-relational use
    private Integer userID;

    private String productName;
    private Integer status;
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(length = 1000)
    private String description;

    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID") // Ensure "userID" exists in the `Users` entity
    private Users user; // Match this field name with `mappedBy` in `Users`

    // Getters and Setters
    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
