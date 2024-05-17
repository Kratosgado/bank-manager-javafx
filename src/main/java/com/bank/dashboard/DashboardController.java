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

        this.addAccount.setOnAction(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("addAccount.fxml"));
            try {
                final Scene scene = fxmlLoader.load();
                AddAccountController controller = fxmlLoader.getController();

                controller.depositButton.setOnAction(event -> {
                    var text = controller.getValues();
                    if (text != null) {
                        System.out.println(text);
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
