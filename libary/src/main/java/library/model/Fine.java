package library.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fine implements Fineable {
    private static final double FINE_PER_DAY = 5000; // 5.000 VNĐ/ngày
    
    private double fine;
    private boolean paid;

    public Fine(double fine) {
        this.fine = fine;
        this.paid = false;
    }
    @Override
    public void payFine(double amount) {
        if (amount >= fine) {
            paid = true;
            System.out.println("Đã thanh toán tiền phạt.");
        } else {
            System.out.println("Thanh toán chưa đủ.");
        }
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public double calculateFine() {
        return fine;
    }
}