package com.bank.dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Pair;

public class AddAccountController {

    @FXML
    private Button createAccountBtn;

    @FXML
    private TextField customerName;

    @FXML
    private TextField initialDeposit;

    public Button getButton() {
        return createAccountBtn;
    }

    public Pair<String, Double> getValues() {
        final String name = this.customerName.getText();
        final Double amount = Double.parseDouble(this.initialDeposit.getText());
        if (name.length() > 0 && amount > 0) {
            return new Pair<String, Double>(name, amount);
        }
        return null;
    }

}
