package com.bank.system;

/**
 * Giao dịch rút tiền.
 */
public class WithdrawTransaction extends Transaction {

  public WithdrawTransaction(String transactionId, double amount, Account account) {
    super(transactionId, amount, account);
  }

  @Override
  public void execute() {
    logger.info("Đang thực hiện giao dịch RÚT TIỀN: {}", transactionId);
    double initialBalance = account.getBalance();

    account.withdraw(amount);

    if (account.getBalance() < initialBalance) {
      logger.info("Giao dịch {} THÀNH CÔNG. Số dư mới: ${}", transactionId, account.getBalance());
    } else {
      logger.error("Giao dịch {} THẤT BẠI.", transactionId);
    }
  }
}