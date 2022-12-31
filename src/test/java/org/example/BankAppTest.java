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
        Assertions.assertEquals("Current balance is 5000.0", bankingService.getPassbookPrintData());
    }
    @Test
    void shouldGetTheLoanInterest() {
        Assertions.assertEquals(7, bankingService.getLoanInterestPercent("homeLoan"));
        Assertions.assertEquals(9, bankingService.getLoanInterestPercent("carLoan"));
        Assertions.assertEquals(12, bankingService.getLoanInterestPercent("personalLoan"));
    }

    @Test
    void shouldAbleSendOTPToMobile() {
       Assertions.assertEquals(
               "OTP send to  number "+account.mobileNo(), bankingService.sendOtp());

    }
}