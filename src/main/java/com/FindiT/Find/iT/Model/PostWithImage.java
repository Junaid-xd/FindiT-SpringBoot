
package com.FindiT.Find.iT.Model;

import jakarta.persistence.Entity;

@Entity
public class PostWithImage extends Post {

    private String imgPath;

    public PostWithImage() {
    }

    public PostWithImage(String productName, Integer status, String location, Users user, String imgPath) {
        super(productName, status, location, user);
        this.imgPath = imgPath;
    }

    // Getter and Setter
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
