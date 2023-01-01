package org.example;

public class SavingAccount extends BankAccount {
    public SavingAccount(String accNo, String name, int mobileNo, String email) {
        super(accNo, name, mobileNo, email);
    }

    public void withdrawMoney(double amt) {
        this.setBalance(this.getBalance() - amt);
    }
}
