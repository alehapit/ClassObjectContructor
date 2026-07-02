package library.model;

public class Book implements Borrowable {
    private String bookId;
    private String title;
    private String author;

    private String currentBorrowerId; // null neu chua ai muon
    private String borrowDate;  

    public Book(String bookId, String title, String author, String currentBorrowerId, String borrowDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.currentBorrowerId = currentBorrowerId;
        this.borrowDate = borrowDate;
    }
    public Book(String bookId, boolean isAvailable) {
        this.bookId = bookId;      
        this.currentBorrowerId = null;
        this.borrowDate = null;
    }
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.currentBorrowerId = null;
        this.borrowDate = null;
    }

    @Override
    public void borrowBy(String readerId, String date) {
        if (isAvailable()) {
            this.currentBorrowerId = readerId;
            this.borrowDate = date;
            System.out.println("Book '" + title + "' borrowed by " + readerId + " on " + date);
        } else {
            System.out.println("Book '" + title + "' is currently not available for borrowing.");
        }
    }
   
    // Getters
    @Override
    public void returnBook(String date) {
        System.out.println("Book '" + title + "' returned on " + date);
        this.currentBorrowerId = null;
        this.borrowDate        = null;
    }

    @Override
    public boolean isAvailable() { return currentBorrowerId == null; }

    @Override
    public String getBorrowerId() { return currentBorrowerId; }

    public String getBookId() { return bookId; }
    public String getTitle()  { return title;  }
    public String getAuthor() { return author; }

}
