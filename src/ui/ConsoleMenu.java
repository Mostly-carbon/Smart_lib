package ui;

import java.util.Scanner;
import model.Book;
import system.LibrarySystem;

public class ConsoleMenu {
    
        private LibrarySystem librarySystem;
        private Scanner scan;

        public ConsoleMenu() {
            librarySystem = new LibrarySystem();
            scan = new Scanner(System.in);
        }

        public void start(){
            while (true) {

                System.out.println("Ladies and gents, welcome to the smart library!\n"+
                "1- Add Book\n" + "2- Search Book by ISBN\n" + "3- Borrow Book\n" + 
                "4- Display Borrowing History\n" + "5- Exit");

                int choice = 0;
                while (true) {
                    try {
                        if (!scan.hasNextLine()) {
                            System.out.println("Input closed. Exiting.");
                            return;
                        }
                        String input = scan.nextLine().trim();
                        choice = Integer.parseInt(input);
                        break;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");}
                }

                switch (choice) {

                    case 1:
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
                        System.out.print("Enter ISBN to search: ");
                        String isbnToSearch = scan.nextLine();

                        Book book = librarySystem.searchBookByIsbn(isbnToSearch);
                        if (book != null) { System.out.println("Book found: " + book);}
                        else {System.out.println("Book not found.");}
                        break;

                    case 3:
                        System.out.print("Enter ISBN to borrow: ");
                        String isbnToBorrow = scan.nextLine();

                        librarySystem.borrowBook(isbnToBorrow);
                        System.out.println("Book borrowed successfully.");
                        break;

                    case 4:
                        librarySystem.displayHistory();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scan.close();
                        return;

                    default:
                        System.out.println("invalid choice, try again");
                }
                    
        }
    }
}


