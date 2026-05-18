package model;

import util.ProductValidator;

public class Product {
    private String name;
    private double price;   
    private String productCode;
    private int quantity = 0;
    private static int counter = 0;
    private static int totalProducts = 0;
    private static double totalRevenue = 0.0;
    private Category category;

    public Product() {
        this.name = "Unknown";
        this.price = 0.0;
        this.productCode = "P-" + String.format("%04d", ++counter);
        this.category = null;
        totalProducts++;
    }
    public Product(String name, double price,Category category) {
        this.name = name;
        this.price = price;
        this.productCode = "P-" + String.format("%04d", ++counter);
        this.quantity = 0;
        this.category = category;
        totalProducts++;
        totalRevenue += price * quantity;
    }
    public Product(String name, double price, int quantity, Category category) {
        this.name = name;
        this.price = price;
        this.productCode = "P-" + String.format("%04d", ++counter);
        this.quantity = quantity;
        this.category = category;
        totalProducts++;
        totalRevenue += price * quantity;
        
    }   
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        }
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        }
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        }
    }

    public double sell(int amount) {
        if (amount > this.quantity || amount <= 0) {
            System.out.println("Not enough stock to sell " + amount + " units of " + name);
            return 0.0;
        }
        this.quantity -= amount;
        double revenue = price * amount;
        totalRevenue += revenue;
        return revenue;
    }
    public int restock(int amount) {
        if (amount <= 0) {
            System.out.println("Restock amount must be positive.");
            return this.quantity;
        }
        this.quantity += amount;
        return this.quantity;
    } 
    public double applyPromotion(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            System.out.println("Invalid discount percentage.");
            return price;
        }
        double discountedPrice = price * (1 - discountPercentage / 100);
        return discountedPrice;
    }
    public static void applyGlobalPromotion(Product[] product, double discountPercentage) {
        for (Product p : product) {
            double newPrice = p.applyPromotion(discountPercentage);
            p.setPrice(newPrice);
        }
    }
    // nếu sản phẩm còn hàng thì không thể hủy, nếu hết hàng thì có thể hủy, tổng số sản phẩm sẽ giảm đi 1 nếu hủy thành công
    public boolean cancelProduct(Product product) {
        if (product.getQuantity() == 0) {
            totalProducts--;
            System.out.println("Cannot cancel product " + product.getName() + " as it has stock.");
            return false;
        }
        System.out.println("Product " + product.getName() + " is cancelled.");
        return true;
    }   
    public void displayInfo() {
        System.out.println("Product Code: " + productCode);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        if (category != null) {
            System.out.println("Category: " + category.getName());
        } else {
            System.out.println("Category: None");
        }
    }
   public static int getTotalProducts() {
        return totalProducts;
    }
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    public static String getStoreReport() {
       return "Total Products: " + totalProducts + ", Total Revenue: $" + totalRevenue;
    }
   
}
