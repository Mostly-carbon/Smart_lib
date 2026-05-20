import java.util.Stack;
import model.Book;

class BorrowingHistoryStack {
    private Stack<Book> history;

    public BorrowingHistoryStack() {
        history = new Stack<>();
    }

    // PUSH book to stack
    public void push(Book book) {
        history.push(book);
    }

    // DISPLAY stack (LIFO order)
    public void display() {
        if (history.isEmpty()) {
            System.out.println("No borrowing history.");
            return;
        }

        System.out.println("Borrowing History (Most Recent First):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}

