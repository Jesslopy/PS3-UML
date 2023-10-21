/*
 * creates a book class
 *
 * --Alexander Jessop--
 */

import java.util.Set;
import java.util.LinkedHashSet;

public abstract class Book implements Comparable<Book> {
    private static LinkedHashSet<String> banned_books = new LinkedHashSet();
    private static int counter_books;
    private String title;
    private int pages;
    private String color;
    private int rating;

    public Book(String title, int pages, String color) {
        this.title= title;
        this.pages= pages;
        this.color= color;
        counter_books++;
    }

    public Book() {
        this("Designing with Objects", 512, "burgundy");
    }


    // Getter and Setter for pages
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean hasSamePages(Book b) {
        if (this.pages == (b.pages)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object b) {
        if (b instanceof Book) {
            Book c = (Book) b;
                if(this.pages==(c.pages)&&(this.title==(c.title))) return true;
        }
        return false;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public abstract int randomRating(); // New abstract method

    public static Set bannedBooks() {
        return banned_books;
    }
    public static void addBannedTitle(String t){
        banned_books.add(t.toUpperCase());
    }
    public static boolean isBanned(Book b) {
        if (banned_books.contains(b.title)) return true;
        else return false;
    }

    public static int numberOfBooks() {
        return counter_books;
    }

    public int hashCode() {
        return (title.hashCode()+Integer.hashCode(pages));
    }
    
    public int compareTo(Book b) {
        if(pages > b.pages) {
            return 1;
        }
        else if(pages < b.pages) {
            return -1;
        }
        return 0;
    }
    public int compare(Book b, Book c) {
        return b.compareTo(c);
    }
}

    
  

