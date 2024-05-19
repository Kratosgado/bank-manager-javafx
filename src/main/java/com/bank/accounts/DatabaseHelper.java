package com.bank.accounts;

import java.sql.*;

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

    public void insertTransaction(Transaction transaction) throws Exception {
        try (
                Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {
            conn.setAutoCommit(false);
            System.out.println("Opened db succ");
            String sql = "INSERT INTO transactions (transactionId, accountNumber, amount, type, name)" +
                    "VALUES (" + transaction.getTransactionId() + ", " + transaction.getAccountNumber() +
                    ", " + transaction.getAmount() + ", " + transaction.getType() + ", " + transaction.getName() + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
