package org.example;

public class BankAccount {
    private double balance;
    private String accNo;
    private String name;
    private int mobileNo;
    private String email;

    public BankAccount(String accNo, String name, int mobileNo, String email) {
        this.accNo = accNo;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public int mobileNo() {
        return this.mobileNo;
    }

    public void addMoney(double amt) {
        this.balance += amt;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return this.email;
    }
}
