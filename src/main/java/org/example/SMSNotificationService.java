package org.example;

public class SMSNotificationService extends NotificationService {
    private BankAccount account;

    public SMSNotificationService(BankAccount account) {
        super(account);
        this.account = account;
    }

    @Override
    String sendOtp() {
        return this.greetAndDisclaimer() + "OTP send to your number " + account.mobileNo();
    }
}
