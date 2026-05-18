package ClassObject.lib;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (balance<0) {
            System.err.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }


    public double getBalance() {
        return balance;
    }

    public String getAccountInfo() {
        int maxLength = accountNumber.length(); // Maximum length for account number display
        // I would limit it to 4 characters displaying for end of account number for better security, but here I will display the first 10 characters as per your request   
        return "Account Number: " +"****"+accountNumber.substring(maxLength-4) + ", Account Holder: " + accountHolderName + ", Balance: " + balance;
    }    
    public void setAccountHolderName(String accountHolderName) {
        if(accountHolderName == null || accountHolderName.trim().isEmpty()) {
            System.err.println("Account holder name cannot be empty. Setting to 'Unknown'.");
            this.accountHolderName = "Unknown";
        } else {
            this.accountHolderName = accountHolderName;
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public boolean transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " to " + targetAccount.getAccountInfo());
            return true;
        } else {
            System.out.println("Invalid transfer amount.");
            return false;
        }
    }

    public boolean setAccountNumber(String accountNumber) {
        //Tài khoản không được thay đổi vì nó gắn với thông tin cá nhân và lịch sử giao dịch của người dùng, việc thay đổi số tài khoản có thể gây nhầm lẫn và rủi ro bảo mật. Nếu cần thay đổi số tài khoản,
        //  người dùng nên liên hệ với ngân hàng để được hỗ trợ và đảm bảo rằng tất cả thông tin liên quan được cập nhật chính xác.
       return false; // Account number should not be changed after creation
    }
}

