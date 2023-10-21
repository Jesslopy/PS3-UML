/*
 * creates a comparator for sorting books by color
 *
 * --Alexander Jessop--
 */

import java.util.Comparator;

public class BookColorComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getColor() == null && book2.getColor() == null) {
            return 0;
        }
        if (book1.getColor() == null) {
            return -1;
        }
        if (book2.getColor() == null) {
            return 1;
        }
        return book1.getColor().compareTo(book2.getColor());
    }
}