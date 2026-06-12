package stack;

import model.Book;

public class StackNode {

    public Book book;      // Stores the book
    public StackNode next; // Points to the next node in the stack

    public StackNode(Book book) {
        this.book = book;
        next = null; // No next node when first created
    }
}