package com.bank.system;

/**
 * Giao dịch nạp tiền.
 */
public class DepositTransaction extends Transaction {

  public DepositTransaction(String transactionId, double amount, Account account) {
    super(transactionId, amount, account);
  }

  @Override
  public void execute() {
    logger.info("Đang thực hiện giao dịch NẠP TIỀN: {}", transactionId);
    account.deposit(amount);
    logger.info("Giao dịch {} THÀNH CÔNG. Số dư mới: ${}", transactionId, account.getBalance());
  }
}