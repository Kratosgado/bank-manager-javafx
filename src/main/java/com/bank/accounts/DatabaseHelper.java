package com.bank.accounts;

import java.sql.*;

import com.bank.accounts.Transaction.TransactionType;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:bank.db";

    public DatabaseHelper() {
        this.createTables();
    }

    private void createTables() {
        try (
                Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "accountNumber INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "balance REAL)";
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "transactionId INTEGER PRIMARY KEY," +
                    "accountNumber INTEGER," +
                    "amount REAL," +
                    "type TEXT," +
                    "name TEXT)";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // /// function to record transaction to sqlite database
    // /**
    //  * @param transaction
    //  * @throws Exception
    //  */
    // public void insertTransaction(Transaction transaction) throws Exception {
    //     try (
    //             Connection conn = DriverManager.getConnection(URL);
    //             Statement stmt = conn.createStatement()) {
    //         conn.setAutoCommit(false);
    //         System.out.println("Opened db succ");
    //         String sql = "INSERT INTO transactions (transactionId, accountNumber, amount, type, name)" +
    //                 "VALUES (" + transaction.getTransactionId() + ", " + transaction.getAccountNumber() +
    //                 ", " + transaction.getAmount() + ", " + transaction.getType() + ", " + transaction.getName() + ");";
    //         stmt.executeUpdate(sql);
    //         stmt.close();
    //         conn.commit();
    //         conn.close();
    //         System.out.println("Records created successfully");
    //     } catch (Exception e) {
    //         System.err.println(e.getClass().getName() + ": " + e.getMessage());
    //         throw new Exception("500");
    //     }
    // }

    public void saveBankAccount(BankAccount bankAccount) {
        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false);

            try (
                    PreparedStatement accountStmt = conn.prepareStatement(
                            "INSERT OR REPLACE INTO accounts(accountNumber, name, balance) VALUES (?,?,?)");
                    PreparedStatement transactionStmt = conn.prepareStatement(
                            "INSERT OR REPLACE INTO transactions (transactionId, accountNumber, amount, type, name) VALUES (?, ?, ?, ?, ?)")) {
                for (CustomerAccount account : bankAccount.getCustomerAccounts().values()) {
                    accountStmt.setInt(1, account.getAccountNumber());
                    accountStmt.setString(2, account.getName());
                    accountStmt.setDouble(3, account.getBalance());
                    accountStmt.addBatch();
                }
                accountStmt.executeBatch();

                for (Transaction transaction : bankAccount.getTransactions()) {
                    transactionStmt.setInt(1, transaction.getTransactionId());
                    transactionStmt.setInt(2, transaction.getAccountNumber());
                    transactionStmt.setDouble(3, transaction.getAmount());
                    transactionStmt.setString(4, transaction.getType().name());
                    transactionStmt.setString(5, transaction.getName());
                    transactionStmt.addBatch();
                }
                transactionStmt.executeBatch();

                conn.commit();
            } catch (SQLException e) {
                // TODO: handle exception
                conn.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public BankAccount loadBankAccount() {
        BankAccount bankAccount = new BankAccount();
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {
            
            ResultSet res = stmt.executeQuery("SELECT * FROM accounts");
            while (res.next()) {
                int accountNumber = res.getInt("accountNumber");
                String name = res.getString("name");
                double balance = res.getDouble("balance");

                CustomerAccount account = new CustomerAccount(name, accountNumber);
                account.makeDeposite(balance);
                // TODO: load customer account
            }
            res = stmt.executeQuery("SELECT * FROM transactions");
            while (res.next()) {
                int transactionId = res.getInt("transactionId");
                int accountNumber = res.getInt("accountNumber");
                double amount = res.getDouble("amount");
                String type = res.getString("type");
                String name = res.getString("name");

                Transaction transaction = new Transaction(transactionId, name, accountNumber, amount,
                        TransactionType.valueOf(type));
                // TODO: load transaction account
                
                // bankAccount.(transaction);
            }
            
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bankAccount;
    }
}
