package system;

import adt.LibraryADT;
import bst.BookBST;
import model.Book;
import stack.HistoryStack;

public class LibrarySystem implements LibraryADT {

    private BookBST catalogue;   // BST storing available books
    private HistoryStack history; // Stack storing borrowed books (LIFO)

    public LibrarySystem() {
        catalogue = new BookBST();     // initialize empty BST
        history = new HistoryStack();  // initialize empty stack
    }

    public void addBook(String isbn, String title, String author) {

        // basic ISBN validation (only numbers and hyphens allowed)
        if (!isbn.matches("[0-9-]+")) {
            System.out.println("Invalid ISBN.");
            return;
        }

        // create new book object and insert into BST
        catalogue.insert(new Book(isbn, title, author));
    }

    public Book searchBookByIsbn(String isbn) {

        // delegate search to BST (recursive search inside tree)
        return catalogue.search(isbn);
    }

    public boolean borrowBook(String isbn) {

        // check if book exists in catalogue (available books only)
        Book book = catalogue.search(isbn);

        if (book == null) {
            return false; // book not found or already borrowed
        }

        // add book to borrowing history stack
        history.push(book);

        // remove book from BST so it cannot be borrowed again
        catalogue.delete(isbn);

        System.out.println("Book borrowed successfully.");

        return true;
    }

    public void displayHistory() {

        // prints stack from newest to oldest (LIFO)
        history.displayHistory();
    }

    public void viewBorrowingHistory() {

        // same functionality (duplicate method for ADT requirement)
        history.displayHistory();
    }
}