package library.model;

import java.time.LocalDate;

public interface Returnable {
    void confirmReturn(String date);

    LocalDate getReturnDate();

    boolean isReturned();

    default boolean isLate(String dueDate) {

        LocalDate today = LocalDate.now();
        LocalDate due = LocalDate.parse(dueDate);

        return today.isAfter(due);
    }
}
