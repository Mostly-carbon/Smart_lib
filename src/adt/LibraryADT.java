import model.Book;
public interface LibraryADT {

    void addBook(String title, String author, String isbn);

    Book searchBookByIsbn(String isbn);

    boolean borrowBook(String isbn);

    void viewBorrowingHistory();
}