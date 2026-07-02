package library.model;

public interface Fineable {
     // Abstract methods
    double calculateFine();

    void payFine(double amount);

    boolean isPaid();

    // Default method
    default double calculateTotalFine(double finePerDay, int overdueDays) {
        return finePerDay * overdueDays;
    }

    // Static method
    static boolean isValidFine(double fine) {
        return fine >= 0;
    }
}
