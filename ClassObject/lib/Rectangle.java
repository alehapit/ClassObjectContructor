package ClassObject.lib;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
    public boolean isSquare() {    
        return width == height;
    }

    public void scale(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
    // Contructor không thể khai báo vì nó đã được khai báo ở trên, nhưng có thể tạo một phương thức để cập nhật kích thước
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        return this;
    }

}
