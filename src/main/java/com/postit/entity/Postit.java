package com.postit.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by SQLI on 02/02/17.
 */
public class Postit {

    @Id
    private String id;

    private String title;

    private String description;

    private String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
