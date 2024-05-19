package com.bank.accounts;

import com.bank.accounts.Transaction.TransactionType;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class BankAccount {
    private DatabaseHelper database;

    private int numOfCustomerAccounts;
    private double moneyInAccount;
    private double moneyOutAccount;
    private final HashMap<Integer, CustomerAccount> clients;
    private ObservableList<Transaction> transactions;

    public BankAccount() {
        this.numOfCustomerAccounts = 0;
        this.moneyInAccount = 0;
        this.moneyOutAccount = 0;
        this.clients = new HashMap<>();
        this.transactions = FXCollections.observableArrayList();

        // establish database connection
        database = new DatabaseHelper();
    }

    public BankAccount loadDatabase() {
        return this.database.loadBankAccount();
    }

    public void saveDatabase() {
        try {
            this.database.saveBankAccount(this);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "BankAccount [numOfCustomerAccounts=" + numOfCustomerAccounts + ", moneyInAccount=" + moneyInAccount
                + ", moneyOutAccount=" + moneyOutAccount + ", clients=" + clients + "]";
    }

    public Transaction createCustomerAccount(String name, double init_deposit) {
        this.numOfCustomerAccounts++;
        CustomerAccount c = new CustomerAccount(name, this.numOfCustomerAccounts);
        c.makeDeposite(init_deposit);
        this.moneyInAccount += init_deposit;
        this.clients.put(this.numOfCustomerAccounts, c);
        System.out.println("account with id " + this.numOfCustomerAccounts + " created successfully");

        return this.recordTransaction(name, c.getAccountNumber(), init_deposit, TransactionType.INITIAL_DEPOSIT);
    }

    private Transaction recordTransaction(String name, int accountNumber, double amount, TransactionType type) {
        try {
            final int transactionId = Double.valueOf(Math.random() * 1000000000).intValue();
            final Transaction transaction = new Transaction(transactionId, name, accountNumber,
                    amount, type);

            // record tansaction
            this.transactions.add(transaction);
            // this.database.insertTransaction(transaction);
            return transaction;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public void addCustomerAccount(CustomerAccount account) {
        this.clients.put(account.getAccountNumber(), account);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public CustomerAccount getCustomerAccount(int accountNumber) throws Error {
        var foundAccount = clients.get((Integer) accountNumber);
        if (foundAccount != null) {
            System.out.println("account with id " + accountNumber + " found");
            return (CustomerAccount) foundAccount;
        }
        throw new Error("No account found for " + accountNumber);
    }

    public Map<Integer, CustomerAccount> getCustomerAccounts() {
        return clients;
    }

    public void updateCustomerAccount(CustomerAccount account) {
        this.clients.put(account.getAccountNumber(), account);
    }

    public Transaction makeDeposite(int accountNumber, double amt) throws Error {
        try {
            var account = getCustomerAccount(accountNumber);
            account.makeDeposite(amt);
            this.moneyInAccount += amt;
            this.updateCustomerAccount(account);

            System.out.println("Deposit of " + amt + " made successfully to " + account.getName());
            return this.recordTransaction(account.getName(), accountNumber, amt, TransactionType.DEPOSIT);

        } catch (Error e) {
            System.err.println("Error making deposit: " + e);
        }
        return null;
    }

    public Transaction makeWithdrawal(int accountNumber, double amt) throws Error {
        try {
            var account = this.getCustomerAccount(accountNumber);
            account.makeWithdrawal(amt);
            this.moneyInAccount -= amt;
            this.moneyOutAccount += amt;
            this.updateCustomerAccount(account);

            System.out.println("Withdrawal of " + amt + " made successfully");
            return this.recordTransaction(account.getName(), accountNumber, amt, TransactionType.WITHDRAWAL);
        } catch (ArithmeticException e) {
            System.err.println("Error making withdrawal: " + e.getMessage());
            return null;
        }
    }

    public ObservableList<Transaction> getTransactions() {
        return this.transactions;
    }

    public Transaction getTransaction(int id) {
        return this.transactions.get((Integer) id);
    }

    public int getNumOfCustomerAccount() {
        return this.numOfCustomerAccounts;
    }

    // create a public function to populate bankaccount with customer accounts and
    // transactions

}
