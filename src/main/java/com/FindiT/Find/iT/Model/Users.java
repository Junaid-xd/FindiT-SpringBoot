


package com.FindiT.Find.iT.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userID;

    @Column(name = "username", unique = true, nullable = false)
    private String username;
    private String password;
    private String imgPath;
    private String contact;
    private boolean isBlocked;


    public Users(){

    }

    public Users(Integer userID, boolean isBlocked, String contact, String imgPath, String password, String username) {
        this.userID = userID;
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

    public boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
