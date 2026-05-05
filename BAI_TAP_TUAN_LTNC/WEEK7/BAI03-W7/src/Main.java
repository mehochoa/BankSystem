class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    // nạp tiền
    //synchronized cho phép 1 luồng truy cập
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    // rút tiền
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);

        // Thread A: nạp tiền
        //dùng lambda
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100);
            }
        });

        // Thread B: rút tiền
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(100);
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join(); //chờ luồng nạp và rút chạy xong rồi mới chạy
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("Lỗi thread: " + e.getMessage());
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}