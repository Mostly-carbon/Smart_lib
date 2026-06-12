package ui;

import java.util.Scanner;
import model.Book;
import system.LibrarySystem;

public class ConsoleMenu {

    private LibrarySystem librarySystem; // system layer (BST + Stack)
    private Scanner scan;                 // handles user input

    public ConsoleMenu() {
        librarySystem = new LibrarySystem();
        scan = new Scanner(System.in);
    }

    public void start() {

        while (true) {

            System.out.println("Ladies and gents, welcome to the smart library!\n" +
                    "1- Add Book\n" +
                    "2- Search Book by ISBN\n" +
                    "3- Borrow Book\n" +
                    "4- Display Borrowing History\n" +
                    "5- Exit");

            int choice = 0;

            // safe input handling for menu selection
            while (true) {
                try {
                    choice = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            switch (choice) {

                case 1:
                    // add new book into BST catalogue
                    System.out.print("Enter ISBN: ");
                    String isbn = scan.nextLine();

                    System.out.print("Enter title: ");
                    String title = scan.nextLine();

                    System.out.print("Enter author: ");
                    String author = scan.nextLine();

                    librarySystem.addBook(isbn, title, author);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // search book in BST using ISBN
                    System.out.print("Enter ISBN to search: ");
                    String isbnToSearch = scan.nextLine();

                    Book book = librarySystem.searchBookByIsbn(isbnToSearch);

                    if (book != null) {
                        System.out.println("Book found: " + book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    // borrow book: remove from BST and push into stack
                    System.out.print("Enter ISBN to borrow: ");
                    String isbnToBorrow = scan.nextLine();

                    boolean success = librarySystem.borrowBook(isbnToBorrow);

                    if (success) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not found or already borrowed.");
                    }
                    break;

                case 4:
                    // display borrowing history (stack - LIFO order)
                    librarySystem.displayHistory();
                    break;

                case 5:
                    // exit program safely
                    System.out.println("Exiting...");
                    scan.close();
                    return;

                default:
                    // invalid menu option
                    System.out.println("Invalid choice, try again");
            }
        }
    }
}