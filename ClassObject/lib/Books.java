package ClassObject.lib;

public class Books {
    public String title;
    public String author;
    public int year;
    public double price;

    public Books() {
        // Default constructor
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 2000;
        this.price = 0.0;
    }

    public Books(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    public Books(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026; // Default year
        this.price = 100000; // Default price
    }


    public void displayInfo() {
        System.out.println("Sácch: " + title +"- Tác giả: " + author + "- Năm xuất bản: " + year + "- Giá: $" + price);
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage < 100) {
            price -= price * (percentage / 100);
        }else {
            System.out.println("Invalid discount percentage." + percentage);
        }
    }

}
