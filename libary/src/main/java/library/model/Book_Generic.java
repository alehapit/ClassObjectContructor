package library.model;

public class Book_Generic implements Comparable<Book_Generic> {
    private String id;
    private String title;
    private String author;
    private int year;
    private int quantity;

    @Override
    public int compareTo(Book_Generic other) {
        return Integer.compare(this.quantity, other.quantity);
    }

    public Book_Generic(String id, String title,  int quantity) {
        this.id = id;
        this.title = title;       
        this.quantity = quantity;
    }
    public Book_Generic(String id, String title, String author, int year, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decreaseQuantity() {
        if (quantity > 0) quantity--;
    }

    public void increaseQuantity() {
        quantity++;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Book[" + id + " - " + title + " - " + author + ", SL: " + quantity + "]";
    }
}