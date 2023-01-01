package org.example;

public class BankingService {
    private BankAccount account;

    public BankingService(BankAccount account) {
        this.account = account;
    }

    public void depositMoney(double amt) {
        account.addMoney(amt);
    }

    public double getAccBalance() {
        return account.getBalance();
    }

}
