import model.Category;

import model.Product;

public class Main {
    public static void main(String[] args) {
        //thêm danh sách category
        Category category1 = new Category("Computers");
        Category category2 = new Category("Phones");


        //hêt 1: laptop, 2: smartphone, 3: tablet
        Product product1 = new Product("Laptop", 1000.0, 5, category1);
        Product product2 = new Product("Smartphone", 500.0, 11, category2);
        Product product3 = new Product("Tablet", 300.0, 8, category1);

        product1.setQuantity(5);
        product1.sell(2);
        product1.restock(1);
        

        product3.setPrice(450.0);
        product3.setName("lE A");
        product3.setQuantity(10);

        product1.displayInfo();
        System.out.println("--------------Het 1---------------");
        product2.displayInfo();
        System.out.println("--------------Het 2---------------");
        product3.displayInfo();
        System.out.println("--------------Report---------------");

        System.out.println("Total Products: " + Product.getTotalProducts());
        System.out.println("Total Revenue: $" + Product.getTotalRevenue());
        System.out.println(Product.getStoreReport());
    }
}
