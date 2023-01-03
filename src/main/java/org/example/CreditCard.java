package org.example;

public class CreditCard implements BankCard {

    public void setTransactionCharge(double transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    private double transactionCharge;

    public CreditCard() {
        this.transactionCharge = 200;
    }

    @Override
    public String withdrawAmount(double amt) {
        return String.format("Withdrawn %.2f from bank & have incurred %.2f as transaction charges", amt, transactionCharge);
    }
}
