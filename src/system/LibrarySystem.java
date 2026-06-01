package system;

import adt.LibraryADT;
import bst.BookBST;
import model.Book;
import stack.HistoryStack;

public class LibrarySystem implements LibraryADT {

    private BookBST catalogue;

    private HistoryStack history;

    public LibrarySystem() {
        catalogue = new BookBST();
        history = new HistoryStack();
    }
    

    public void addBook(String isbn, String title, String author) {
        Book book = new Book(isbn,title,author);
        catalogue.insert(book);
    }

    public Book searchBookByIsbn(String isbn) {
        return catalogue.search(isbn);
    }

    public boolean borrowBook(String isbn) {

        if (catalogue.search(isbn) == null) {
            return false;
        }

        else {
            history.push(catalogue.search(isbn));
            catalogue.delete(isbn);
            System.out.println("Book borrowed successfully.");
            return true;
        }

    }

    public void displayHistory() {
        history.displayHistory();
    }

    public void viewBorrowingHistory() {
        history.displayHistory();
    }

}