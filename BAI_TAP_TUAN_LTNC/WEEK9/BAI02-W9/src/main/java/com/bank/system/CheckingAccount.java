package com.bank.system;

/**
 * Tai khoan thanh toan.
 */
public class CheckingAccount extends Account {

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      this.balance -= amount;
      logger.info("Rut tien thanh cong: -{}", amount);
    }
  }

  @Override
  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
    }
  }

  @Override
  public String getAccountInfo() {
    return "Checking Account: " + accountNumber + ", Balance: $" + balance;
  }
}