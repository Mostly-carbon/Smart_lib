package service;

import adt.LibraryADT;
import bst.BookBST;
import model.Book;
import stack.HistoryStack;

public class LibrarySystemTEMP implements LibraryADT {

    private final BookBST catalogue;
    private final HistoryStack history;

    public LibrarySystemTEMP() {
        this.catalogue = new BookBST();
        this.history = new HistoryStack();
    }

    @Override
    public void addBook(String isbn, String title, String author) {
        Book newBook = new Book(isbn, title, author);
        catalogue.insert(newBook);
        System.out.println("Success: Added \"" + title + "\" to the catalogue.");
    }

    @Override
    public Book searchBookByIsbn(String isbn) {
        Book book = catalogue.search(isbn);
        if (book != null) {
            System.out.println("\n[Book Found]");
            System.out.println(book);
        } else {
            System.out.println("Result: Book with ISBN " + isbn + " not found.");
        }
        return book;
    }

    /**
     * TASK 5: ADMIN LOGIC
     * Removes the book from the BST catalogue and pushes it onto the history stack.
     */
    @Override
    public boolean borrowBook(String isbn) {
        // Your BookBST.delete method automatically finds and removes the node,
        // returning the Book object or null if it doesn't exist.
        Book borrowedBook = catalogue.delete(isbn);
        
        if (borrowedBook != null) {
            // Push to custom linked-list stack
            history.push(borrowedBook);
            System.out.println("Success: You have borrowed \"" + borrowedBook.getTitle() + "\".");
            return true;
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " is unavailable or already borrowed.");
            return false;
        }
    }

    @Override
    public void viewBorrowingHistory() {
        System.out.println("\n--- Borrowing History (Most Recent First) ---");
        history.displayHistory();
    }
}
