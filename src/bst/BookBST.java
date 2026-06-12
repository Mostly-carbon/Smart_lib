package bst;

import model.Book;

public class BookBST {

    private BSTNode root; // root of the BST

    public BookBST() {
        root = null; // start with empty tree
    }

    // INSERT a book into BST
    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BSTNode insertRec(BSTNode root, Book book) {

        if (root == null) {
            return new BSTNode(book); // create new node
        }

        if (book.getIsbn().compareTo(root.book.getIsbn()) < 0) {
            root.left = insertRec(root.left, book); // go left
        }

        else if (book.getIsbn().compareTo(root.book.getIsbn()) > 0) {
            root.right = insertRec(root.right, book); // go right
        }

        return root;
    }

    // SEARCH using recursion
    public Book search(String isbn) {
        return searchRec(root, isbn);
    }

    private Book searchRec(BSTNode root, String isbn) {

        if (root == null) {
            return null; // not found
        }

        if (isbn.equals(root.book.getIsbn())) {
            return root.book; // found
        }

        if (isbn.compareTo(root.book.getIsbn()) < 0) {
            return searchRec(root.left, isbn); // go left
        }

        else {
            return searchRec(root.right, isbn); // go right
        }
    }

    // DELETE a book
    public Book delete(String isbn) {

        Book deletedBook = search(isbn); // check first

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

            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // one child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // two children
            BSTNode successor = findMin(root.right);

            root.book = successor.book;

            root.right = deleteRec(root.right, successor.book.getIsbn());
        }

        return root;
    }

    // find smallest node in right subtree
    private BSTNode findMin(BSTNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // print sorted books (inorder traversal)
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