package Prototype;

import java.io.Serializable;

public class Book implements Cloneable, Serializable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    protected Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Book(this.author, this.title, this.genre, this.publicationYear);
        }
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s, %d)", title, author, genre, publicationYear);
    }
}
