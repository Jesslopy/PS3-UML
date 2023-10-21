/*
 * creates a non-fiction subclass for books
 *
 * --Alexander Jessop--
 */

public class NonFiction extends Book {
    private int callNumber;

    public NonFiction() {
        this.callNumber = 005;
    }

    public NonFiction(String title, int pages, String color, int callNumber) {
        setTitle(title);
        setPages(pages);
        setColor(color);
        this.callNumber = callNumber;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public boolean hasSameCallNumber(NonFiction other) {
        return this.callNumber == other.callNumber;
    }

    @Override
    public int randomRating() {
        if (callNumber <= 333) {
            return (int) (Math.random() * 3 + 3);
        } else if (callNumber <= 666) {
            return (int) (Math.random() * 3 + 1);
        } else {
            return (int) (Math.random() * 3 + 2);
        }
    }

    @Override
    public String toString() {
        // Assuming you have a callNumber field in NonFiction
        return super.toString() + "\nnumber " + callNumber;
    }
}
