/*
 * implements memento pattern to keep track of a book's circulation by year
 *
 * --Alexander Jessop--
 */
import java.util.List;
import java.util.LinkedList;

public class Book {
    private String title;
    private int year;
    private int numberOfBorrowers;

    // Constructor with parameters
    public Book(String title, int year, int numberOfBorrowers) {
        this.title = title;
        this.year = year;
        this.numberOfBorrowers = numberOfBorrowers;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for current circulation as a formatted string
    public String getCurrentCirculation() {
        return year + " " + numberOfBorrowers;
    }

    // Save the current state of the book as a Memento
    public Memento saveState() {
        return new Memento(year,numberOfBorrowers);
    }

    // Restore the state of the book from a Memento
    public void restoreState(Memento memento) {
        year = memento.getSavedYear();
        numberOfBorrowers = memento.getSavedBorrowers();
    }

    // Inner Memento class
    public static class Memento {
        private int year;
        private int borrowers;

        public Memento(int year, int borrowers) {
            this.year = year;
            this.borrowers = borrowers;
        }

        private int getSavedYear() {
            return year;
        }
        public int getSavedBorrowers() {
            return borrowers;
        }
    }



    public static class Caretaker {
        private List<Memento> mementoList = new LinkedList<>();

        public void add(Memento state) {
            mementoList.add(state);
        }

        public Memento get(int index) {
            return mementoList.get(index);
        }
    }
}
