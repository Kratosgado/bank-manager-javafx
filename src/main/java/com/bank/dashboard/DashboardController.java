/**
 * Sample Skeleton for 'mainpage.fxml' Controller Class
 */

package com.bank.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import com.bank.accounts.BankAccount;

import javafx.fxml.FXML;

public class DashboardController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    private BankAccount bankAccount;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        this.bankAccount = new BankAccount();
    }

}
