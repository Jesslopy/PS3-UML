/*
 * creates a fiction subclass for books
 *
 * --Alexander Jessop--
 */

import java.util.ArrayList;
import java.util.List;

public class Fiction extends Book {
    private static Genre genre;
    private static List<Fiction> fictionSignedOut = new ArrayList<>();

    private Fiction(String title, Genre genre) {
        super(title);
        this.genre = genre;
    }

    public static Fiction borrowFiction(String title, Genre genre) throws BookLimitException {
        if (fictionSignedOut.size() >= 2) {
            throw new BookLimitException("Maximum borrowing reached!");
        }

        Fiction fiction = new Fiction(title, genre);
        fictionSignedOut.add(fiction);
        return fiction;
    }

    public static boolean returnFiction(String title) {
        for (Fiction fiction : fictionSignedOut) {
            if (fiction.getTitle().equals(title)) {
                fictionSignedOut.remove(fiction);
                return true;
            }
        }
        return false;
    }

    public static List<Fiction> fictionSignedOut() {
        return fictionSignedOut;
    }

    @Override
    public String toString() {
        return super.toString() + "\ngenre " + genre;
    }
}
