package org.example;

public class BankATMService {
    private BankCard bankCard;

    public BankATMService(BankCard debitCard) {
        this.bankCard = debitCard;
    }

    public String withdrawMoney(double amt) {
        return this.bankCard.withdrawAmount(amt);
    }
}
