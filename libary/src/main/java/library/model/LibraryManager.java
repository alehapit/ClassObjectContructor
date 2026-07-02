package library.model;

import java.util.List;

public class LibraryManager {
    public void processAllBorrowable(List<Borrowable> items) {

        for (Borrowable item : items) {

            System.out.println(item + " -> " + item.isAvailable());
        }
    }

    public void notifyAll(List<Notifiable> users,
                          String message) {

        for (Notifiable user : users) {
            user.sendNotification(message);
        }
    }
}
