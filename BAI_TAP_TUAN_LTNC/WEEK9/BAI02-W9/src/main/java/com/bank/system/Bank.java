package com.bank.system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quan ly he thong ngan hang.
 */
public class Bank {
  private static final Logger logger = LoggerFactory.getLogger(Bank.class);
  private List<Customer> customerList = new ArrayList<>();

  /**
   * Doc danh sach tu file.
   */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      return;
    }
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        processLine(line);
      }
    } catch (Exception e) {
      logger.error("Loi doc file", e);
    }
  }

  private void processLine(String line) {
    // Logic xu ly tung dong tai day
  }

  /**
   * Lay thong tin theo thu tu ID.
   */
  public String getCustomersInfoByIdOrder() {
    return customerList.stream()
        .sorted(Comparator.comparingLong(Customer::getIdNumber))
        .map(Customer::getCustomerInfo)
        .collect(Collectors.joining("\n"));
  }
}