import java.io.PrintStream;

public class App {
    public static void main(String[] args) throws Exception {
        //phần 1: Tạo đối tượng Books và hiển thị thông tin
        ClassObject.lib.Books book1 = new ClassObject.lib.Books();
        book1.title = "The Great Gatsby";
        book1.author = "F. Scott Fitzgerald";
        book1.year = 1925;
        book1.price = 10.99;

        ClassObject.lib.Books book2 = new ClassObject.lib.Books("To Kill a Mockingbird", "Harper Lee", 1960, 7.99);
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        book1.displayInfo();
        book2.displayInfo();

        ClassObject.lib.Books book3 = new ClassObject.lib.Books("1984", "George Orwell");
        book3.displayInfo();
        book3.applyDiscount(10); // Apply a 10% discount
        book3.displayInfo();

        //phần 2: Tạo đối tượng Rectangle và hiển thị thông tin
        ClassObject.lib.Rectangle rect1 = new ClassObject.lib.Rectangle();
        System.out.println("Area of rect1: " + rect1.getArea());
        System.out.println("Perimeter of rect1: " + rect1.getPerimeter());
        System.out.println("Is rect1 a square? " + rect1.isSquare());
        ClassObject.lib.Rectangle rect2 = new ClassObject.lib.Rectangle(4.0);
        System.out.println("Area of rect2: " + rect2.getArea());
        System.out.println("Perimeter of rect2: " + rect2.getPerimeter());
        System.out.println("Is rect2 a square? " + rect2.isSquare());
        ClassObject.lib.Rectangle rect3 = new ClassObject.lib.Rectangle(4.0, 5.0);
        System.out.println("Area of rect3: " + rect3.getArea());
        System.out.println("Perimeter of rect3: " + rect3.getPerimeter());
        System.out.println("Is rect3 a square? " + rect3.isSquare());

        ClassObject.lib.Rectangle rect4 = new ClassObject.lib.Rectangle(rect3);
        System.out.println("Area of rect4: " + rect4.getArea());
        System.out.println("Perimeter of rect4: " + rect4.getPerimeter());
        System.out.println("Is rect4 a square? " + rect4.isSquare());
        rect4.scale(2.0);
        System.out.println("After scaling rect4 by a factor of 2:");
        System.out.println("Area of rect4: " + rect4.getArea());
        System.out.println("Perimeter of rect4: " + rect4.getPerimeter());
        System.out.println("Is rect4 a square? " + rect4.isSquare());   

        //phần 3: Tạo đối tượng BankAccount và hiển thị thông tin
        ClassObject.lib.BankAccount account1 = new ClassObject.lib.BankAccount("123456789", "John Doe", 1000.0);
        System.out.println(account1.getAccountInfo());  
        account1.deposit(500.0);
        System.out.println("Balance after deposit: " + account1.getBalance());
        account1.withdraw(200.0);
        System.out.println("Balance after withdrawal: " + account1.getBalance());
        account1.setAccountHolderName("Jane Doe");
        System.out.println(account1.getAccountInfo());  

        ClassObject.lib.BankAccount account2 = new ClassObject.lib.BankAccount("987654321", "Alice Smith", -500.0);
        System.out.println(account2.getAccountInfo());
        account2.deposit(-1000.0); // Invalid deposit
        account2.withdraw(100.0); // Invalid withdrawal


        ClassObject.lib.BankAccount account3 = new ClassObject.lib.BankAccount("555555555", "Bob Johnson", 500.0);
        account1.transfer(account3, 300.0); // Valid transfer
        System.out.println("Balance of account1 after transfer: " + account1.getBalance()); // Should be 1200.0 after transfer
        System.out.println("Balance of account3 after receiving transfer: " + account3.getBalance()); // Should be 800.0 after receiving transfer
    }
}
