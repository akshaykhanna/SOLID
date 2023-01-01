package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAppTest {

    private BankAccount account;
    private BankingService bankingService;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACN123", "John", 999912345, "john@xyz.com");
        bankingService = new BankingService(account);
        bankingService.depositMoney(5000);
    }

    @Test
    void shouldAbleToDepositMoney() {
        Assertions.assertEquals(5000, bankingService.getAccBalance());
    }

    @Test
    void shouldAbleToWithdrawMoney() {
        bankingService.withdrawMoney(2000);
        Assertions.assertEquals(3000, bankingService.getAccBalance());
    }

    @Test
    void shouldAbleToGetPrintDataForPassbook() {
        var printService = new PrintService(account);
        Assertions.assertEquals("Current balance is 5000.0", printService.getPassbookPrintData());
    }

    @Test
    void shouldGetTheLoanInterest() {
        LoanService loanService = new LoanService();
        Assertions.assertEquals(7, loanService.getInterestPercent("homeLoan"));
        Assertions.assertEquals(9, loanService.getInterestPercent("carLoan"));
        Assertions.assertEquals(12, loanService.getInterestPercent("personalLoan"));
    }

    @Test
    void shouldAbleSendOTPToMobileWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new SMSNotificationService(account);

        String expected = String.format(
                "Hi %s, Please don't share this OTP with anyone. OTP send to your number %s"
                , account.name(), account.mobileNo());

        Assertions.assertEquals(expected, notificationService.sendOtp());
    }
    @Test
    void shouldAbleSendOTPToEmailWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new EmailNotificationService(account);

        String expected = String.format(
                "Hi %s, Please don't share this OTP with anyone. OTP send to your email %s"
                , account.name(), account.email());

        Assertions.assertEquals(expected, notificationService.sendOtp());
    }
}