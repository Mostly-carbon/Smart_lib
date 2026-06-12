package model;

public class Book {

    private String isbn;   // Unique identifier for the book
    private String title;  // Book title
    private String author; // Book author

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn; // Returns ISBN
    }

    public String getTitle() {
        return title; // Returns title
    }

    public String getAuthor() {
        return author; // Returns author
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                ", Title: " + title +
                ", Author: " + author;
        // Formats book details for printing
    }
}