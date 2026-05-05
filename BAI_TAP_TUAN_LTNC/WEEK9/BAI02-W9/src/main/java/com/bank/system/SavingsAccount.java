package com.bank.system;

/**
 * Tài khoản tiết kiệm.
 */
public class SavingsAccount extends Account {
  private static final double MIN_BALANCE = 500.0;

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void withdraw(double amount) {
    if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
      this.balance -= amount;
      logger.info("Rút tiền từ TK Tiết kiệm {}: -${}", accountNumber, amount);
    } else {
      logger.error("Rút tiền thất bại tại TK Tiết kiệm {}: Vi phạm số dư tối thiểu", accountNumber);
    }
  }

  @Override
  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
      logger.info("Nạp tiền vào TK Tiết kiệm {}: +${}", accountNumber, amount);
    }
  }

  @Override
  public String getAccountInfo() {
    return String.format("Savings Account: %d, Balance: $%.2f", accountNumber, balance);
  }
}