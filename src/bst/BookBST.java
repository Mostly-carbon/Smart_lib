class BookBST {
    private BSTNode root;

    public BookBST() {
        root = null;
    }

    // INSERT BOOK INTO BST
    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BSTNode insertRec(BSTNode root, Book book) {
        if (root == null) {
            return new BSTNode(book);
        }

        if (book.getIsbn().compareTo(root.book.getIsbn()) < 0) {
            root.left = insertRec(root.left, book);
        } else if (book.getIsbn().compareTo(root.book.getIsbn()) > 0) {
            root.right = insertRec(root.right, book);
        }

        return root;
    }

    // Getter for root (used by teammate for recursive search)
    public BSTNode getRoot() {
        return root;
    }
}
