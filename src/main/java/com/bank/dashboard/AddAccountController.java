package com.bank.dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Pair;

public class AddAccountController {

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField amountField;

    @FXML
    public Button depositButton;

    public Pair<Integer, Double> getValues() {
        final Integer accountNumber = Integer.parseInt(this.accountNumberField.getText());
        final Double amount = Double.parseDouble(this.amountField.getText());
        if (accountNumber > 0 && amount > 0) {
            return new Pair<Integer, Double>(accountNumber, amount);
        }
        return null;
    }
    

}
