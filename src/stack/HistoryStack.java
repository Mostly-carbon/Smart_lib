package stack;

import model.Book;

public class HistoryStack {

    private StackNode top;

    public HistoryStack() {
        top = null;
    }

    // PUSH BOOK TO STACK
    public void push(Book book) {

        StackNode newNode = new StackNode(book);

        newNode.next = top;

        top = newNode;
    }

    // DISPLAY HISTORY
    public void displayHistory() {

        if (top == null) {
            System.out.println("No borrowing history.");
            return;
        }

        StackNode current = top;

        while (current != null) {

            System.out.println(current.book);

            current = current.next;
        }
    }
}