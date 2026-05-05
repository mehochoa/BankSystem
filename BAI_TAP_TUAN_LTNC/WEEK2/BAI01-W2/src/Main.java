class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            System.out.println("Số dư không hợp lệ, đặt mặc định bằng 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp thành công: " + amount);
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0){
            System.out.println("Số tiền rút phải lớn hơn 0");
        } else if (amount > balance) {
            System.out.println("Số dư của bạn không đủ");
        } else {
            balance -= amount;
            System.out.println("Bạn đã rút thành công :" + amount);
        }
    }

    public double getBalance(){
        return balance;
    }
}

public class Main{
    public static void main(String[] args){
        BankAccount acc = new BankAccount("123456", "Dung", 1000);
        acc.deposit(-50);
        acc.withdraw(2000);
        acc.deposit(500);
        acc.withdraw(500);
        System.out.println("Số dư hiện tại:" + acc.getBalance());
    }
}