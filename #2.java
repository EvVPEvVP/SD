public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;  // нет проверки на отрицательную сумму
    }

    public void withdraw(double amount) {
        balance -= amount;  // баланс может стать отрицательным
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);

        account.deposit(50.0);
        account.withdraw(20.0);
        System.out.println("Баланс после обычных операций: " + account.getBalance());

        account.deposit(-30.0);   //отрицательный депозит
        account.withdraw(200.0);  //уход в минус
        System.out.println("Баланс после операций без проверок: " + account.getBalance());
    }
}
