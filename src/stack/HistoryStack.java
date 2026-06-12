package stack;

import model.Book;

public class HistoryStack {

    private StackNode top; // Points to the top of the stack

    public HistoryStack() {
        top = null; // Stack starts empty
    }

    // PUSH BOOK TO STACK
    public void push(Book book) {

        StackNode newNode = new StackNode(book);

        newNode.next = top; // Link new node to current top

        top = newNode; // New node becomes the top
    }

    // DISPLAY HISTORY
    public void displayHistory() {

        if (top == null) {
            System.out.println("No borrowing history.");
            return;
        }

        StackNode current = top;

        while (current != null) {

            System.out.println(current.book); // Print current book

            current = current.next; // Move to next node
        }
    }
}