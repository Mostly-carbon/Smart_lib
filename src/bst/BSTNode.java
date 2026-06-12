package bst;

import model.Book;

public class BSTNode {

    public Book book;        // stores the book object
    public BSTNode left;     // left child (smaller ISBN)
    public BSTNode right;    // right child (greater ISBN)

    public BSTNode(Book book) {
        this.book = book;     // assign book to node
        left = null;          // initialize left as empty
        right = null;         // initialize right as empty
    }
}