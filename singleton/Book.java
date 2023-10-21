/*
 * implements singleton pattern for limited interlibrary borrowing
 *
 * --Alexander Jessop--
 */

import java.util.ArrayList;
import java.util.List;

public class Book {
    private static List<Book> booksSignedOut = new ArrayList<>();
    private String title;
    private static final int BORROW_LIMIT = 2;  // Set your desired borrow limit
    private static int borrowedCount = 0;

    protected Book(String t) {
        this.title = t;
    }

    public static Book borrowBook(String t) throws BookLimitException {
        if (borrowedCount >= BORROW_LIMIT) {
            throw new BookLimitException("You have reached the borrowing limit.");
        }

        Book book = new Book(t);
        booksSignedOut.add(book);
        borrowedCount++;
        return book;
    }

    public static boolean returnBook(String t) {
        for (Book book : booksSignedOut) {
            if (book.getTitle().equals(t)) {
                booksSignedOut.remove(book);
                borrowedCount--;
                return true;
            }
        }
        return false;
    }

    public static List<Book> booksSignedOut() {
        return booksSignedOut;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }
}

