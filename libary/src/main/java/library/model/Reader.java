package library.model;

import java.util.ArrayList;
import java.util.List;

public class Reader implements Notifiable {
    private String id;
    private String name;
    private String email;

    private List<String> history = new ArrayList<>();

    public Reader(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Reader(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public void sendNotification(String message) {

        history.add(message);

        System.out.println(name + " nhận thông báo: " + message);
    }

    @Override
    public List<String> getNotificationHistory() {
        return history;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
    public int getMaxBorrow() {
        return 0;
    }
}