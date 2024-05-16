/**
 * Sample Skeleton for 'dashboard.fxml' Controller Class
 */

package com.bank.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import com.bank.accounts.BankAccount;
import com.bank.accounts.Transaction;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="accountTable"
    private TableView<Transaction> accountTable; // Value injected by FXMLLoader

    @FXML // fx:id="addAccount"
    private MenuItem addAccount; // Value injected by FXMLLoader

    @FXML // fx:id="hBox"
    private HBox hBox; // Value injected by FXMLLoader

    @FXML // fx:id="makeDeposit"
    private MenuItem makeDeposit; // Value injected by FXMLLoader

    @FXML // fx:id="makeWithdrawal"
    private MenuItem makeWithdrawal; // Value injected by FXMLLoader

    @FXML // fx:id="scene"
    private Scene scene; // Value injected by FXMLLoader

    @FXML // fx:id="updateAccount"
    private MenuItem updateAccount; // Value injected by FXMLLoader

    @FXML // fx:id="vBox"
    private VBox vBox; // Value injected by FXMLLoader

    private BankAccount bankAccount;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        this.bankAccount = new BankAccount();
    }

}
