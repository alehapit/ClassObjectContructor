
package library.com;
import library.model.Book;
import library.model.Book_Generic;
import library.model.BorrowSlip;
import library.model.Borrowable;
import library.model.Fine;
import library.model.Fineable;
import library.model.Lecturer;
import library.model.Library;
import library.model.LibraryManager;
import library.model.Librarian;
import library.model.Reader;
import library.model.ReaderType;
import library.model.Student;
import library.model.GenericStack;
import library.model.Pair;
import library.model.LibraryUtils;
import library.model.Notifiable;
import library.model.Borrowable;
import library.model.Searchable;
import library.model.Borrowable;
import library.model.BorrowSlip;
import library.model.Fine;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

     try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {}

        Library library = new Library();

        // Tạo sách
        Book b1 = new Book("B001", "Lập trình Java", "James Gosling");
        Book b2 = new Book("B002", "Cơ sở dữ liệu", "Elmasri");

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

        ///generic stack test
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Muon sach 1");
        stack.push("Muon sach 2");
        System.out.println("Phan tu o dinh stack: " + stack.peek());
        System.out.println("So luong phan tu trong stack: " + stack.size());
        stack.pop();
        System.out.println("Phan tu o dinh stack sau khi pop: " + stack.peek());
        stack.pop();
        System.out.println("Stack rong: " + stack.isEmpty());
         // ===============================
        // GenericStack<Integer>
        // ===============================

        GenericStack<Integer> errorCodes = new GenericStack<>();

        errorCodes.push(100);
        errorCodes.push(200);
        errorCodes.push(404);

        System.out.println("\nDanh sach ma loi:");

        while (!errorCodes.isEmpty()) {
            System.out.println(errorCodes.pop());
        }

         //=========================
        // Pair<String,Integer>
        //=========================

        Pair<String, Integer> book1 =
                new Pair<>("B001", 15);

        Pair<String, Integer> book2 =
                new Pair<>("B002", 8);

        System.out.println(book1);
        System.out.println(book2);

        boolean same =
                Pair.comparePairs(book1, book2);

        System.out.println("Hai Pair bang nhau? " + same);

        if (book1.getValue() > book2.getValue()) {
            System.out.println("Sach muon nhieu hon: " + book1);
        } else {
            System.out.println("Sach muon nhieu hon: " + book2);
        }

        //=========================
        // Pair<String,String>
        //=========================

        Pair<String, String> reader =
                new Pair<>("Nguyen Van A", "DG001");

        System.out.println("\nPair goc:");
        System.out.println(reader);

        Pair<String, String> swapped =
                Pair.swap(reader);

        System.out.println("Sau khi swap:");
        System.out.println(swapped);

        //===========================
        // findMin()
        //===========================

        Book_Generic[] books = {

                new Book_Generic("B001","Java",15),
                new Book_Generic("B002","C#",8),
                new Book_Generic("B003","Python",22)

        };

        Book_Generic minBook = LibraryUtils.findMin(books);

        System.out.println("Sach co luot muon nho nhat:");
        System.out.println(minBook);

        //===========================
        // printAll()
        //===========================

        List<Reader> readers = new ArrayList<>();

        readers.add(new Reader("R001","Nguyen Van A"));
        readers.add(new Reader("R002","Tran Thi B"));

        System.out.println("\nDanh sach Reader:");

        LibraryUtils.printAll(readers);

        //===========================
        // copyList()
        //===========================

        List<Book_Generic> source = new ArrayList<>();

        source.add(new Book_Generic("B004","SQL",30));
        source.add(new Book_Generic("B005","Oracle",18));

        List<Object> destination = new ArrayList<>();

        LibraryUtils.copyList(destination, source);

        System.out.println("\nDanh sach sau khi copy:");

        LibraryUtils.printAll(destination);

        //interface test
        System.out.println("\nInterface test:");
        Borrowable bookIter1 = new Book("B001", "Clean Code", "Robert Martin");
        Borrowable bookIter2 = new Book("B002", "Design Patterns", "GoF");

        bookIter1.borrowBy("R001", "2024-09-01");
        System.out.println("Available: " + bookIter2.isAvailable()); // true

        // Dung static method cua interface
        System.out.println(Borrowable.isValidBorrowDuration(10)); // true
        System.out.println(Borrowable.isValidBorrowDuration(20)); // false

        // Dung default method
        System.out.println(bookIter1.calculateFine(3)); // 15000.0

        bookIter2.returnBook("2024-09-15");
        
        //test borrow slip
       BorrowSlip slip = new BorrowSlip();

        System.out.println("Da tra? " + slip.isReturned());

        slip.confirmReturn("2025-07-20");

        System.out.println("Ngay tra: " + slip.getReturnDate());

        System.out.println("Da tra? " + slip.isReturned());

        System.out.println("Qua han? " +
                slip.isLate("2025-07-15"));

        Library libraryB = new Library();

       libraryB.addBook(new Book("B001", "Java Programming", "James Gosling"));
       libraryB.addBook(new Book("B002", "Python Programming", "Guido van Rossum"));

        System.out.println("\nTim theo tieu de:");

        for(Book b : libraryB.searchByTitle("java")){
            System.out.println(b);
        }

        System.out.println("\nTim theo tac gia:");

        for(Book b : libraryB.searchByAuthor("james")){
            System.out.println(b);
        }

        //test notifiable
        System.out.println("\nTest Notifiable:");
         //================ Fine ==================

        Fine fine = new Fine(50000.0);

        System.out.println(fine.calculateFine());

        System.out.println(
                fine.calculateTotalFine(5000,5));

        System.out.println(
                Fineable.isValidFine(10000));

        fine.payFine(50000);

        System.out.println(fine.isPaid());

        //================ Reader =================

        Reader r1 = new Reader("R001","An");
        Reader r2 = new Reader("R002","Bình");

        r1.sendOverdueNotification();

        //================ Library ================

        List<Borrowable> booksN = new ArrayList<>();

        booksN.add(new Book("Java",true));
        booksN.add(new Book("Python",false));

        LibraryManager manager = new LibraryManager();

        manager.processAllBorrowable(booksN);

        List<Notifiable> readerss = new ArrayList<>();

        readerss.add(r1);
        readerss.add(r2);

        manager.notifyAll(readerss,
                "Thư viện nghỉ lễ vào Chủ nhật.");
    

    }  
}