//package com.FindiT.Find.iT.Model;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users") // Optional, specifies the table name
//public class Users {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer userID;
//
//    private String username;
//    private String password;
//    private String imgPath;
//    private String contact;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Post> posts;
//
//    // Getters and Setters
//
//    public Integer getUserID() {
//        return userID;
//    }
//
//    public void setUserID(Integer userID) {
//        this.userID = userID;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getImgPath() {
//        return imgPath;
//    }
//
//    public void setImgPath(String imgPath) {
//        this.imgPath = imgPath;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//}




package com.FindiT.Find.iT.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userID;

    private String username;
    private String password;
    private String imgPath;
    private String contact;
    private boolean isBlocked;

    // One User can have many Posts (One-to-Many Relationship)
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Post> posts = new ArrayList<>();

    public Users(){

    }

    public Users(Integer userID, List<Post> posts, boolean isBlocked, String contact, String imgPath, String password, String username) {
        this.userID = userID;
//        this.posts = posts;
        this.isBlocked = isBlocked;
        this.contact = contact;
        this.imgPath = imgPath;
        this.password = password;
        this.username = username;
    }

    // Getters and Setters
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

//    public List<Post> getPosts() {
//        return posts;
//    }

//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }


    public boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
