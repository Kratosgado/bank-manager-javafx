package com.bank.accounts;

public class Transaction {
    private final int transactionId;
    private final String name;
    private final int accountNumber;
    private final double amount;
    private final TransactionType type;

    public enum TransactionType {
        INITIAL_DEPOSIT,
        DEPOSIT,
        WITHDRAWAL
    }

    public Transaction(int transactionId, String name, int accountNumber, double amount, TransactionType type) {
        this.transactionId = transactionId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public String getName() {
        return this.name;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getAmount() {
        return this.amount;
    }

    public TransactionType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Transaction [accountNumber=" + accountNumber + ", amount=" + amount + ", transactionId=" + transactionId
                + ", type=" + type + "]";
    }
}
