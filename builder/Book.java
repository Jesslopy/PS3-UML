/*
 * implements builder pattern to enable easy cataloguing of books with 
 * partial information
 *
 * --Alexander Jessop--
 */

 import java.util.Set;
 import java.util.LinkedHashSet;

 
public class Book implements Comparable<Book> {
    protected String title;
    protected int pages;
    protected String color;
    protected int rating;
    protected String author;
    protected int year;

    private Book(Builder builder) {
        this.title = builder.title;
        this.pages = builder.pages;
        this.color = builder.color;
        this.rating = builder.rating;
        this.author = builder.author;
        this.year = builder.year;
    }

    public static class Builder {
        private String title;
        private int pages;
        private String color;
        private int rating;
        private String author;
        private int year;

        public Builder(String title, int pages) {
            this.title = title;
            this.pages = pages;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }
        
        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int randomRating(){
        return (int) (Math.random() * 5) + 1;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
    @Override
    public String toString() {
        if (year == 0) return title + " " + pages + " pages " + author;
        if (author == null) return title + " " + pages + " pages" + " " + year;
        return title + " " + pages + " pages " + author + " " + year;
    }

}