/*
 * uses Book as a property of BookCollection (composition)
 *
 * --Alexander Jessop--
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class BookCollection {
    private Book favoriteBook;
    private List<Book> books;


    public Book getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(Book favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book b) throws BannedBookException {
        if (b != null) {
            if (Book.isBanned(b)) {
                throw new BannedBookException("This book is banned and cannot be added to the collection.");
            } else {
                books.add(b);
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (Book b : books) {
            output = output + b.getTitle() + "\n";
        }
        return output;
    }
}

