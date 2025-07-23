import java.util.ArrayList;

/**
 * Lớp Account đại diện cho tài khoản ngân hàng,
 * bao gồm số dư hiện tại và danh sách các giao dịch đã thực hiện.
 */
public class Account {
    private double balance; // Số dư tài khoản
    private ArrayList<Transaction> transitionList; // Danh sách các giao dịch

    /**
     * Khởi tạo một tài khoản mới với số dư ban đầu là 0.
     */
    public Account() {
        this.balance = 0.0;
        this.transitionList = new ArrayList<>();
    }

    /**
     * Thực hiện nạp tiền vào tài khoản.
     * Nếu số tiền hợp lệ, cập nhật số dư và ghi nhận giao dịch.
     *
     * @param amount số tiền cần nạp
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Thực hiện rút tiền từ tài khoản.
     * Kiểm tra tính hợp lệ trước khi cập nhật số dư và ghi nhận giao dịch.
     *
     * @param amount số tiền cần rút
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
            transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
        }
    }

    /**
     * Thêm một giao dịch vào danh sách, gọi đúng loại nạp hoặc rút.
     *
     * @param amount    số tiền giao dịch
     * @param operation loại giao dịch: "DEPOSIT" hoặc "WITHDRAW"
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Hiển thị thông tin về tất cả các giao dịch đã thực hiện.
     * Số tiền và số dư được làm tròn đến hai chữ số thập phân.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction t = transitionList.get(i);
            String op = t.getOperation().equalsIgnoreCase(Transaction.DEPOSIT)
                        ? "Nap tien" : "Rut tien";
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",
                              i + 1, op, t.getAmount(), t.getBalance());
        }
    }
}
