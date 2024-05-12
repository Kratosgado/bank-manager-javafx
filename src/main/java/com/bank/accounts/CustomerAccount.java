package com.bank.accounts;

public class CustomerAccount {
    private final int accountNumber;
    private double balance;

    public CustomerAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void makeDeposite(double amount) {
        this.balance += amount;
    }

    public void makeWithdrawal(double amount) throws ArithmeticException {
        double res = this.balance - amount;
        if (res < 0) {
            throw new ArithmeticException("Not Enough Balance");
        }
        this.balance = res;
    }

    @Override
    public String toString() {
        return "CustomerAccount [accountNumber=" + accountNumber + ", balance=" + balance + "]";
    }
}
