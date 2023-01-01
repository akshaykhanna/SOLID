package org.example;

public class EmailNotificationService extends NotificationService {
    private BankAccount account;

    public EmailNotificationService(BankAccount account) {
        super(account);
        this.account = account;
    }

    @Override
    String sendOtp() {
        return this.greetAndDisclaimer() + "OTP send to your email " + account.email();
    }

}
