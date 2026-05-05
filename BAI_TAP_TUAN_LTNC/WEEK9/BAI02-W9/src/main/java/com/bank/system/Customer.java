package com.bank.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Dai dien cho khach hang.
 */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accounts;

  /**
   * Constructor khach hang.
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accounts = new ArrayList<>();
  }

  /**
   * Them tai khoan cho khach.
   */
  public void addAccount(Account account) {
    if (account != null) {
      accounts.add(account);
    }
  }

  public long getIdNumber() {
    return idNumber;
  }

  /**
   * Lay thong tin tong hop.
   */
  public String getCustomerInfo() {
    StringBuilder sb = new StringBuilder();
    sb.append("Customer: ").append(fullName).append(" (").append(idNumber).append(")\n");
    for (Account acc : accounts) {
      sb.append("- ").append(acc.getAccountInfo()).append("\n");
    }
    return sb.toString().trim();
  }
}