import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        this.balance = 0.0;
        this.transitionList = new ArrayList<>();
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

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

    public void addTransaction(double amount, String operation) {
        if (operation.equalsIgnoreCase(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equalsIgnoreCase(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction t = transitionList.get(i);
            String op = t.getOperation().equalsIgnoreCase(Transaction.DEPOSIT) ? "Nap tien" : "Rut tien";
            System.out.printf("Giao dich %d: %s $%.2f. So du luc nay: $%.2f.\n",
                    i + 1, op, t.getAmount(), t.getBalance());
        }
    }
}
