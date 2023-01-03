package org.example;

public class DebitCard implements BankCard {
    public String withdrawAmount(double amt) {
        return String.format("Withdrawn %.2f from bank", amt);
    }
}
