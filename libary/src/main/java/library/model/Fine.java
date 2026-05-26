package library.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fine {
    private static final double FINE_PER_DAY = 5000; // 5.000 VNĐ/ngày

    public static double calculateFine(BorrowSlip slip) {
        if (slip.getReturnDate() == null) {
            long daysLate = ChronoUnit.DAYS.between(slip.getDueDate(), LocalDate.now());
            return daysLate > 0 ? daysLate * FINE_PER_DAY : 0;
        }
        long daysLate = ChronoUnit.DAYS.between(slip.getDueDate(), slip.getReturnDate());
        return daysLate > 0 ? daysLate * FINE_PER_DAY : 0;
    }
}