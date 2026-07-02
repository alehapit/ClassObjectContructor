package library.model;

import java.util.List;

public interface Notifiable {
      void sendNotification(String message);

    List<String> getNotificationHistory();

    default void sendOverdueNotification() {
        sendNotification("Sách của bạn đã quá hạn. Vui lòng trả sách.");
    }
}
