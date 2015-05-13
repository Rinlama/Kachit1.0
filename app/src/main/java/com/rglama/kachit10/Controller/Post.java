package com.rglama.kachit10.Controller;

/**
 * Created by Rinjin on 5/13/15.
 */
public class Post {
    String name;
    String email;
    String title;
    String address;
    String description;

    public Post(String name, String email, String title, String address, String description) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.address = address;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  "Title: " + title +"\n" +
                "Name: " + name +"\n" +
                "Email:  " + email +"\n" +
                "Address:  " + address +"\n" +
                "Description:  " + description +"\n"
                ;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
