
package library.com;
import library.model.Book;
import library.model.BorrowSlip;
import library.model.Lecturer;
import library.model.Library;
import library.model.Librarian;
import library.model.Reader;
import library.model.ReaderType;
import library.model.Student;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

     try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {}

        Library library = new Library();

        // Tạo sách
        Book b1 = new Book("B001", "Lập trình Java", "James Gosling", 2020, 5);
        Book b2 = new Book("B002", "Cơ sở dữ liệu", "Elmasri", 2018, 3);

        // Tạo độc giả
        Student s1 = new Student("SV001", "Nguyễn Văn A", "a@student.edu.vn");
        Lecturer l1 = new Lecturer("GV001", "Trần Thị B", "b@lecturer.edu.vn");

        library.addBook(b1);
        library.addBook(b2);
        library.addReader(s1);
        library.addReader(l1);

        // Kiểm tra
        library.printAllBooks();
        library.printAllReaders();

        System.out.println("\nSố sách tối đa sinh viên mượn: " + s1.getMaxBorrow());
        System.out.println("Số sách tối đa giảng viên mượn: " + l1.getMaxBorrow());
}}