package library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void printAllBooks() {
        System.out.println("=== DANH SÁCH SÁCH ===");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void printAllReaders() {
        System.out.println("=== DANH SÁCH ĐỘC GIẢ ===");
        for (Reader r : readers) {
            System.out.println(r);
        }
    }
}