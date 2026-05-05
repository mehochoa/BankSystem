class Transaction {
    private final String transactionId;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionId(){
        return transactionId;
    }
    public double getAmount(){
        return amount;
    }
    public String getTimestamp(){
        return timestamp;
    }
}
class Account{
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int count = 0;

    public Account(String accountId, double balance, int size){
        this.accountId = accountId;
        this.balance = balance;
        history = new Transaction[size];
    }

    public void addTransaction(Transaction t){
        history[count++] = t;
    }

    public Transaction[] getHistory() {
        Transaction[] copy = new Transaction[count];
        for (int i = 0; i < count; i++){
            copy[i] = history[i];
        }
        return copy;
    }
}

public class Main{
    public static void main(String[] args){
        Account acc = new Account("ACC01",1000,10);
        acc.addTransaction(new Transaction("T1",100,"2024-01-01"));
        acc.addTransaction(new Transaction("T2",200,"2024-01-02"));

        Transaction[] hacked = acc.getHistory();
        hacked[0] = null;
        Transaction[] real = acc.getHistory();
        System.out.println(real[0].getTransactionId());
        System.out.println(real[0].getAmount());
    }
}