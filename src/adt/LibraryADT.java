package adt;

import model.Book;

public interface LibraryADT {

    void addBook(String isbn, String title, String author);

    Book searchBookByIsbn(String isbn);

    boolean borrowBook(String isbn);

    void viewBorrowingHistory();
}