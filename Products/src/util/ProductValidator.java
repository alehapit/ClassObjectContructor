package util;

public class ProductValidator {   
   public static boolean isValidName(String name) {
        if (name == null || name.isEmpty()|| name.length() <=2) {
            System.out.println("Product name cannot be empty.");
            return false;
        }
        return true;
    }
    public static boolean isValidPrice(double price) {
        if (price < 0) {
            System.out.println("Product price cannot be negative.");
            return false;
        }
        return true;
    }
    public static boolean isValidQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Product quantity cannot be negative.");
            return false;
        }
        return true;
    }
}
