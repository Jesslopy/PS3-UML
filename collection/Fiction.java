/*
 * creates a fiction subclass for books
 *
 * --Alexander Jessop--
 */

public class Fiction extends Book {
    private Genre genre;

    public Fiction() {
        // Default values
        setTitle("Murder on the Orient Express");
        setPages(212);
        setColor("white");
        this.genre = Genre.MYSTERY;
    }

    public Fiction(String title, int pages, String color, Genre genre) {
        setTitle(title);
        setPages(pages);
        setColor(color);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isSameGenre(Fiction other) {
        return this.genre == other.genre;
    }

    @Override
    public int randomRating() {
        switch (genre) {
            case MYSTERY:
                return (int) (Math.random() * 3 + 3);
            case FANTASY:
                return (int) (Math.random() * 3 + 2);
            case HUMOR:
                return (int) (Math.random() * 5 + 1);
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\ngenre " + genre;
    }

    @Override
    public int compareTo(Book other) {
        // This is a basic implementation comparing titles. Modify as needed.
        return this.getTitle().compareTo(other.getTitle());
    }
}