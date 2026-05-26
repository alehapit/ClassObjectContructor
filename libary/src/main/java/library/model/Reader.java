package library.model;

public class Reader {
    private String id;
    private String name;
    private String email;

    public Reader(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getMaxBorrow() {
        return 0; // Mặc định lớp cha
    }

    @Override
    public String toString() {
        return "Reader[" + id + " - " + name + " - " + email + "]";
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}