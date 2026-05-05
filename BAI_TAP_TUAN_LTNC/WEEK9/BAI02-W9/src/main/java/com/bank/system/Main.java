package com.bank.system;

import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop khoi chay chuong trinh he thong ngan hang.
 */
public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  /**
   * Phuong thuc chinh de chay ung dung.
   *
   * @param args tham so dau vao.
   */
  public static void main(String[] args) {
    logger.info("He thong dang khoi dong...");

    Bank bank = new Bank();

    // Doc file tu thu muc resources
    InputStream is = Main.class.getResourceAsStream("/customers.txt");

    if (is != null) {
      bank.readCustomerList(is);
      logger.info("Da nap du lieu khach hang thanh cong.");
    } else {
      logger.error("Khong tim thay file customers.txt trong resources!");
    }

    // In ra danh sach da sap xep
    System.out.println("--- Danh sach khach hang theo ID ---");
    String info = bank.getCustomersInfoByIdOrder();
    System.out.println(info);

    logger.info("Chuong trinh ket thuc.");
  }
}