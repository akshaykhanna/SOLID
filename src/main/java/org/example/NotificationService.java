package org.example;

public abstract class NotificationService {
    private BankAccount account;

    public NotificationService(BankAccount account) {
        this.account = account;
    }

    abstract String sendOtp();

    protected String greetAndDisclaimer() {
        return String.format("Hi %s, Please don't share this OTP with anyone. ", account.name());
    }

}
