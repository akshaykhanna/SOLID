package org.example;

public class LoanService {
    public float getInterestPercent(String loanType) {
        switch (loanType) {
            case "homeLoan":
                return 7;
            case "carLoan":
                return 9;
            case "personalLoan":
                return 12;
        }
        return 15;
    }
}