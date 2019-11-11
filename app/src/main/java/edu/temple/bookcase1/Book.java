package edu.temple.bookcase1;

import java.util.ArrayList;

public class Book {

    int id;
    String title;
    String author;
    int published;
    String coverURL;

    //constructor for book obj
    public Book(int id, String title, String author, int published, String coverURL){
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
        this.coverURL = coverURL;

    }

    //getters and setters
    public int getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublished() {
        return published;
    }

    public String getCoverURL() {
        return coverURL;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    ArrayList<Book> bookArrayList = new ArrayList<Book>();


}
