package org.example;

public class BankingService {
    private BankAccount account;

    public BankingService(BankAccount account) {

        this.account = account;
    }

    public void depositMoney(double amt) {
        account.setBalance(account.getBalance() + amt);
    }

    public double getAccBalance() {
        return account.getBalance();
    }

    public void withdrawMoney(double amt) {
        this.account.setBalance(this.account.getBalance() - amt);
    }

    public String getPassbookPrintData() {
        return "Current balance is " + account.getBalance();
    }

    public float getLoanInterestPercent(String loanType) {
        switch (loanType) {
            case "homeLoan":
                return 7;
            case "carLoan":
                return 9;
            case "personalLoan":
                return 12;
        }
        return 15;
    }

    public String sendOtp() {
        return "OTP send to  number " + account.mobileNo();
    }
}
