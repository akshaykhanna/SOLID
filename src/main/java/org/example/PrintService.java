package org.example;

public class PrintService {
    private BankAccount account;

    public PrintService(BankAccount account) {
        this.account = account;
    }

    public String getPassbookPrintData() {
        return "Current balance is " + account.getBalance();
    }
}
