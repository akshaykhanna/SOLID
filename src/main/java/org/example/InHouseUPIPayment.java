package org.example;

public class InHouseUPIPayment implements UPIPaymentsInterface, CashBackInterface {

    private double cashbackPercent;
    private SavingAccount savingAccount;

    public InHouseUPIPayment(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String payMoney(double amt, String reciversUPI) {
        if (amt > savingAccount.getBalance())
            return "UPI payment failed. Insufficient balance";
        String paidStatement = String.format("%.2f has been paid to UPI id %s.", amt, reciversUPI);
        return String.format("%s %s", paidStatement, this.getCashbackAsCreditBalance(amt));
    }

    @Override
    public String getCashbackAsCreditBalance(double amt) {
        cashbackPercent = 0.05;
        return String.format("Have received %.2f cashback", amt * cashbackPercent);
    }
}
