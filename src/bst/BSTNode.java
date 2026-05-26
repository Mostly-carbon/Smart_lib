package bst;

import model.Book;

public class BSTNode {

    public Book book;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(Book book) {
        this.book = book;
        left = null;
        right = null;
    }
}