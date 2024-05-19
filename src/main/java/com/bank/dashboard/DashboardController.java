package com.bank.dashboard;

import java.io.IOException;

import com.bank.App;
import com.bank.accounts.BankAccount;
import com.bank.accounts.Transaction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private TableColumn<Transaction, String> accountNumber;

    @FXML
    private TableColumn<Transaction, String> transactionId;

    @FXML
    private TableColumn<Transaction, String> type;

    @FXML
    private TableColumn<Transaction, String> name;

    @FXML
    private TableColumn<Transaction, Double> amount;

    @FXML
    private TableView<Transaction> accountTable;

    @FXML
    private MenuItem addAccount;

    @FXML
    private HBox hBox;

    @FXML
    private MenuItem makeDeposit;

    @FXML
    private MenuItem makeWithdrawal;

    @FXML
    private Scene scene;

    @FXML
    private MenuItem updateAccount;

    private BankAccount bankAccount;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        this.bankAccount = new BankAccount();
        this.bankAccount.populateBankAccount();

        this.amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.transactionId.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        this.accountNumber.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        this.type.setCellValueFactory(new PropertyValueFactory<>("type"));

        accountTable.setItems(this.bankAccount.getTransactions());
        // this.accountTable.setFa

        // handle making deposit
        this.makeDeposit.setOnAction(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("deposit.fxml"));
            try {
                final Scene scene = fxmlLoader.load();
                MakeDepositController controller = fxmlLoader.getController();

                controller.depositButton.setOnAction(event -> {
                    var addPair = controller.getValues();
                    if (addPair != null) {
                        this.bankAccount.makeDeposite(addPair.getKey(), addPair.getValue());
                        System.out.println(addPair);
                    }
                });

                Stage popupStage = new Stage();
                popupStage.setTitle("Make a deposi");
                popupStage.setScene(scene);
                popupStage.showAndWait();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });

    }

}
