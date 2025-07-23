public class Transaction {
    private String operation;  // Loại giao dịch: "DEPOSIT" hoặc "WITHDRAW"
    private double amount;     // Số tiền giao dịch
    private double balance;    // Số dư sau giao dịch

    /**
     * Hằng số đại diện cho loại giao dịch nạp tiền.
     */
    public static final String DEPOSIT = "DEPOSIT";

    /**
     * Hằng số đại diện cho loại giao dịch rút tiền.
     */
    public static final String WITHDRAW = "WITHDRAW";

    /**
     * Khởi tạo một giao dịch mới với loại giao dịch, số tiền và số dư hiện tại.
     *
     * @param operation tên loại giao dịch (ví dụ: "DEPOSIT" hoặc "WITHDRAW")
     * @param amount    số tiền được nạp hoặc rút trong giao dịch
     * @param balance   số dư còn lại trong tài khoản sau khi giao dịch hoàn tất
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * Lấy loại giao dịch.
     *
     * @return tên loại giao dịch
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Thiết lập loại giao dịch.
     *
     * @param operation tên loại giao dịch mới
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Lấy số tiền giao dịch.
     *
     * @return số tiền đã giao dịch
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Thiết lập số tiền giao dịch.
     *
     * @param amount số tiền cần thiết lập
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Lấy số dư tài khoản sau giao dịch.
     *
     * @return số dư hiện tại
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Thiết lập số dư tài khoản sau giao dịch.
     *
     * @param balance số dư mới cần thiết lập
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
