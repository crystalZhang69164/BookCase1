package edu.temple.bookcase1;

import java.util.ArrayList;

public class Book {

    int id;
    String title;
    String author;
    int published;
    String coverURL;

    public Book(int id, String title, String author, int published, String coverURL){
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
        this.coverURL = coverURL;

    }

    ArrayList<Book> bookArrayList = new ArrayList<Book>();
}
