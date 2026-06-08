package main;

import adt.LibraryADT;
import service.LibrarySystemTEMP;
import java.util.Scanner;

public class ConsoleMainTEMP {

    public static void main(String[] args) {
        LibraryADT library = new LibrarySystemTEMP();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Smart Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ISBN");
            System.out.println("3. Borrow Book");
            System.out.println("4. View Borrowing History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            String choiceInput = scanner.nextLine().trim();
            
            switch (choiceInput) {
                case "1":
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine().trim();
                    
                    if (isbn.isEmpty() || title.isEmpty() || author.isEmpty()) {
                        System.out.println("Validation Error: Fields cannot be empty.");
                    } else {
                        library.addBook(isbn, title, author);
                    }
                    break;
                    
                case "2":
                    System.out.print("Enter ISBN to search: ");
                    String searchIsbn = scanner.nextLine().trim();
                    library.searchBookByIsbn(searchIsbn);
                    break;
                    
                case "3":
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine().trim();
                    library.borrowBook(borrowIsbn);
                    break;
                    
                case "4":
                    library.viewBorrowingHistory();
                    break;
                    
                case "5":
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}
