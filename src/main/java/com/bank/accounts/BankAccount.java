package com.bank.accounts;

import java.util.HashMap;

public class BankAccount {
    @Override
    public String toString() {
        return "BankAccount [numOfCustomerAccounts=" + numOfCustomerAccounts + ", moneyInAccount=" + moneyInAccount
                + ", moneyOutAccount=" + moneyOutAccount + ", clients=" + clients + "]";
    }

    private int numOfCustomerAccounts;
    private double moneyInAccount;
    private double moneyOutAccount;
    private final HashMap<Integer, CustomerAccount> clients;

    public BankAccount() {
        this.numOfCustomerAccounts = 0;
        this.moneyInAccount = 0;
        this.moneyOutAccount = 0;
        this.clients = new HashMap<>();
    }

    public int addAccount(String name, int init_deposit) {
        this.numOfCustomerAccounts++;
        CustomerAccount c = new CustomerAccount(name, this.numOfCustomerAccounts);
        c.makeDeposite(init_deposit);
        this.moneyInAccount += init_deposit;
        this.clients.put(this.numOfCustomerAccounts, c);
        System.out.println("account with id " + this.numOfCustomerAccounts + " created successfully");

        return this.numOfCustomerAccounts;
    }

    public CustomerAccount getCustomerAccount(int accountNumber) throws Error {
        var foundAccount = clients.get((Integer) accountNumber);
        if (foundAccount != null) {
            System.out.println("account with id " + accountNumber + " found");
            return (CustomerAccount) foundAccount;
        }
        throw new Error("No account found for " + accountNumber);
    }

    public void updateCustomerAccount(CustomerAccount account) {
        this.clients.put(account.getAccountNumber(), account);
    }

    public void makeDeposite(int accountNumber, double amt) throws Error {
        try {
            var account = getCustomerAccount(accountNumber);
            account.makeDeposite(amt);
            this.moneyInAccount += amt;
            this.updateCustomerAccount(account);
            System.out.println("Deposit of " + amt + "made successfully to " + account.getName());

        } catch (Error e) {
            System.err.println("Error making deposit: " + e);
        }
    }

    public void makeWithdrawal(int accountNumber, int amt) throws Error {
        try {
            var account = this.getCustomerAccount(accountNumber);
            account.makeWithdrawal(amt);
            this.moneyInAccount -= amt;
            this.moneyOutAccount += amt;
            this.updateCustomerAccount(account);
            System.out.println("Withdrawal of " + amt + " made successfully");
        } catch (ArithmeticException e) {
            System.err.println("Error making withdrawal: " + e.getMessage());

        }
    }

    public int getNumOfCustomerAccount() {
        return this.numOfCustomerAccounts;
    }
}
