package com.FindiT.Find.iT.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PostWithDescription extends Post {

    @Column(length = 1000)
    private String description;

    public PostWithDescription() {
    }

    public PostWithDescription(String productName, Integer status, String location, Users user, String description) {
        super(productName, status, location, user);
        this.description = description;
    }

    // Getter and Setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
