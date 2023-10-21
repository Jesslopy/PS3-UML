/*
 * creates a comparator for sorting books by rating 
 *
 * --Alexander Jessop--
 */

import java.util.Comparator;

public class BookRatingComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getRating(), b2.getRating());
    }
}