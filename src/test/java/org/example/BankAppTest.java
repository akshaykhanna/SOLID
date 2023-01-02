package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAppTest {

    private SavingAccount savingAccount;
    private WithdrawalBankingService withdrawalBankingService;
    private FixedDepositAccount fdAccount;
    private BankingService fixedDepositBankingService;
    private int fixedDepositedAmount;
    private int savingDepositedAmount;

    @BeforeEach
    void setUp() {
        savingAccount = new SavingAccount("ACN123", "John", 999912345, "john@xyz.com");
        fdAccount = new FixedDepositAccount("ACN123", "John", 999912345, "john@xyz.com");
        withdrawalBankingService = new WithdrawalBankingService(savingAccount);
        savingDepositedAmount = 5000;
        withdrawalBankingService.depositMoney(savingDepositedAmount);
        fixedDepositBankingService = new BankingService(fdAccount);
        fixedDepositedAmount = 25000;
        fixedDepositBankingService.depositMoney(fixedDepositedAmount);
    }

    @Test
    void shouldAbleToDepositMoney() {
        Assertions.assertEquals(savingDepositedAmount, withdrawalBankingService.getAccBalance());
    }

    @Test
    void shouldAbleToDepositMoneyToFixedDeposit() {
        Assertions.assertEquals(fixedDepositedAmount, fixedDepositBankingService.getAccBalance());
    }

    @Test
    void shouldAbleToWithdrawMoney() {
        withdrawalBankingService.withdrawMoney(2000);
        Assertions.assertEquals(3000, withdrawalBankingService.getAccBalance());
    }

    @Test
    void shouldNotAbleToWithdrawMoneyFromFixedDeposit() {
//      fixedDepositBankingService.withdrawMoney(2000); As we cannot withdraw money from fixed deposit
        Assertions.assertEquals(25000, fixedDepositBankingService.getAccBalance());
    }

    @Test
    void shouldAbleToGetPrintDataForPassbook() {
        var printService = new PrintService(savingAccount);
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
        NotificationService notificationService = new SMSNotificationService(savingAccount);

        String expected = String.format("Hi %s, Please don't share this OTP with anyone. OTP send to your number %s", savingAccount.name(), savingAccount.mobileNo());

        Assertions.assertEquals(expected, notificationService.sendOtp());
    }

    @Test
    void shouldAbleSendOTPToEmailWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new EmailNotificationService(savingAccount);

        String expected = String.format("Hi %s, Please don't share this OTP with anyone. OTP send to your email %s", savingAccount.name(), savingAccount.email());

        Assertions.assertEquals(expected, notificationService.sendOtp());
    }

    @Test
    void shouldAbleToPaymentsViaUPIUsingGooglePay() {
        UPIPaymentsInterface googlePayUPI = new UPIViaGooglePay(savingAccount);
        double paidAmount = 400;
        String reciverUPI = "bond@upi.bank";

        String expected = String.format("%.2f has been paid to UPI id %s. Have received a scratch card. Have received %.2f cashback", paidAmount, reciverUPI, paidAmount * 0.01);

        Assertions.assertEquals(expected, googlePayUPI.payMoney(paidAmount, reciverUPI));
    }

    @Test
    void shouldAbleToPaymentsViaUPIUsingInHouseUPIPayment() {
        UPIPaymentsInterface googlePayUPI = new InHouseUPIPayment(savingAccount);
        double paidAmount = 400;
        String reciverUPI = "bond@upi.bank";

        String expected = String.format("%.2f has been paid to UPI id %s. Have received %.2f cashback", paidAmount, reciverUPI, paidAmount * 0.05);

        Assertions.assertEquals(expected, googlePayUPI.payMoney(paidAmount, reciverUPI));
    }

    @Test
    void shouldAbleToPaymentsViaUPIUsingPaytm() {
        UPIPaymentsInterface googlePayUPI = new UPIViaPaytm(savingAccount);
        double paidAmount = 400;
        String reciverUPI = "bond@upi.bank";

        String expected = String.format("%.2f has been paid to UPI id %s.", paidAmount, reciverUPI);

        Assertions.assertEquals(expected, googlePayUPI.payMoney(paidAmount, reciverUPI));
    }

}