/**
 * Sample Skeleton for 'loginscreen.fxml' Controller Class
 */

package com.bank.auth;

import java.net.URL;
import java.util.ResourceBundle;

import com.bank.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Username: " + username);
        App.navigator.pushFXML("dashboard");
    }

}
