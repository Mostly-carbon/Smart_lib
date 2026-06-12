package adt;

import model.Book;   // Import the Book class so the interface can use it

public interface LibraryADT {

    void addBook(String isbn, String title, String author);
    // Adds a new book into the library system

    Book searchBookByIsbn(String isbn);
    // Searches for a book using its ISBN and returns the Book object

    boolean borrowBook(String isbn);
    // Borrows a book if it exists, returns true if successful

    void viewBorrowingHistory();
    // Displays the borrowing history stored in the stack
}