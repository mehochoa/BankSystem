package com.bank.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop truu tuong dai dien cho mot giao dich ngan hang.
 */
public abstract class Transaction {
  protected static final Logger logger = LoggerFactory.getLogger(Transaction.class);

  protected String transactionId;
  protected double amount;
  protected LocalDateTime timestamp;
  protected Account account;

  /**
   * Khoi tao giao dich.
   */
  public Transaction(String transactionId, double amount, Account account) {
    this.transactionId = transactionId;
    this.amount = amount;
    this.account = account;
    this.timestamp = LocalDateTime.now();
  }

  /**
   * Thuc thi giao dich.
   */
  public abstract void execute();

  /**
   * Lay thong tin tom tat giao dich.
   */
  public String getTransactionSummary() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return String.format("[%s] ID: %s | Amount: $%.2f | Account: %d",
        timestamp.format(formatter), transactionId, amount, account.getAccountNumber());
  }
}