package bst;

import model.Book;

public class BookBST {

    private BSTNode root;

    public BookBST() {
        root = null;
    }

    // INSERT
    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BSTNode insertRec(BSTNode root, Book book) {

        if (root == null) {
            return new BSTNode(book);
        }

        if (book.getIsbn().compareTo(root.book.getIsbn()) < 0) {
            root.left = insertRec(root.left, book);
        }

        else if (book.getIsbn().compareTo(root.book.getIsbn()) > 0) {
            root.right = insertRec(root.right, book);
        }

        return root;
    }

    // RECURSIVE SEARCH
    public Book search(String isbn) {
        return searchRec(root, isbn);
    }

    private Book searchRec(BSTNode root, String isbn) {

        if (root == null) {
            return null;
        }

        if (isbn.equals(root.book.getIsbn())) {
            return root.book;
        }

        if (isbn.compareTo(root.book.getIsbn()) < 0) {
            return searchRec(root.left, isbn);
        }

        else {
            return searchRec(root.right, isbn);
        }
    }

    // DELETE
    public Book delete(String isbn) {

        Book deletedBook = search(isbn);

        if (deletedBook != null) {
            root = deleteRec(root, isbn);
        }

        return deletedBook;
    }

    private BSTNode deleteRec(BSTNode root, String isbn) {

        if (root == null) {
            return null;
        }

        if (isbn.compareTo(root.book.getIsbn()) < 0) {
            root.left = deleteRec(root.left, isbn);
        }

        else if (isbn.compareTo(root.book.getIsbn()) > 0) {
            root.right = deleteRec(root.right, isbn);
        }

        else {

            // NO CHILD
            if (root.left == null && root.right == null) {
                return null;
            }

            // ONE CHILD
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // TWO CHILDREN
            BSTNode successor = findMin(root.right);

            root.book = successor.book;

            root.right = deleteRec(root.right,
                                   successor.book.getIsbn());
        }

        return root;
    }

    private BSTNode findMin(BSTNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // DISPLAY SORTED BOOKS
    public void printInOrder() {
        printInOrderRec(root);
    }

    private void printInOrderRec(BSTNode root) {

        if (root != null) {

            printInOrderRec(root.left);

            System.out.println(root.book);

            printInOrderRec(root.right);
        }
    }
}