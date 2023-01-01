package org.example;

public class WithdrawalBankingService extends BankingService{
    private SavingAccount savingAccount;

    public WithdrawalBankingService(SavingAccount savingAccount) {
        super(savingAccount);
        this.savingAccount = savingAccount;
    }

    public void withdrawMoney(double amt) {
        savingAccount.withdrawMoney(amt);
    }
}
