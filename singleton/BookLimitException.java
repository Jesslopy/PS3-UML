/*
 * --Alexander Jessop--
 */
import java.util.List;
import java.util.Iterator;

public class BookLimitException extends Exception {
    public BookLimitException() {
        super("You have reached the borrowing limit.");
    }

    public BookLimitException(String message) {
        super(message);
    }
}

