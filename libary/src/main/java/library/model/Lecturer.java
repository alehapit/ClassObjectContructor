package library.model;

public class Lecturer extends Reader {

    public Lecturer(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() + " - Loại: Giảng Viên (Max: 5 cuốn)";
    }
    
}
