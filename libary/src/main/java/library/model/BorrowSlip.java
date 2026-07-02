package library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BorrowSlip implements Returnable {

    private String id;
    private Reader reader;
    private Book_Generic book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowSlip() {
        returned = false;
    }
    public BorrowSlip(String id, Reader reader, Book_Generic book, LocalDate borrowDate, LocalDate dueDate) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    // Getters & Setters
    public String getId() { return id; }
    public Reader getReader() { return reader; }
    public Book_Generic getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public void confirmReturn(String returnDateString) {
        if (returnDateString == null || returnDateString.isBlank()) {
            this.returnDate = LocalDate.now();
            return;
        }
        this.returnDate = LocalDate.parse(returnDateString);
    }

    @Override
    public boolean isReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return String.format("Phieu[%s] - %s - %s - Muon: %s - Han: %s", 
                id, reader.getName(), book.getTitle(), borrowDate, dueDate);
    }
}