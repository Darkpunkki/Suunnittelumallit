package Prototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable, Serializable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    // Getters and Setters
    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    protected Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return new Recommendation(this.targetAudience, new ArrayList<>(this.books));
        }
    }

    // Modification methods
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String bookTitle) {
        books.removeIf(b -> b.getTitle().equalsIgnoreCase(bookTitle));
    }

    public void changeTargetAudience(String newAudience) {
        this.targetAudience = newAudience;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target Audience: ").append(targetAudience).append("\nBooks:");
        if (books.isEmpty()) {
            sb.append(" No books added yet.");
        } else {
            for (Book book : books) {
                sb.append("\n- ").append(book.toString());
            }
        }
        return sb.toString();
    }
}
