package stack;

import model.Book;

public class StackNode {

    public Book book;
    public StackNode next;

    public StackNode(Book book) {
        this.book = book;
        next = null;
    }
}
