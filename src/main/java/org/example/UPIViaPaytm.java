package org.example;

public class UPIViaPaytm implements UPIPaymentsInterface {
    private SavingAccount savingAccount;

    public UPIViaPaytm(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String payMoney(double amt, String reciversUPI) {
        if (amt > savingAccount.getBalance())
            return "UPI payment failed. Insufficient balance";
        String paidStatement = String.format("%.2f has been paid to UPI id %s.", amt, reciversUPI);
        return String.format("%s", paidStatement);
    }
}
