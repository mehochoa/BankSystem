package com.bank.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop truu tuong dai dien cho tai khoan ngan hang.
 */
public abstract class Account {
  protected static final Logger logger = LoggerFactory.getLogger(Account.class);

  protected long accountNumber;
  protected double balance;

  /**
   * Khoi tao tai khoan.
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public abstract void withdraw(double amount);

  public abstract void deposit(double amount);

  public abstract String getAccountInfo();
}