package com.bank.auth;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button login;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private Button signupButton;

    @FXML
    private TextField username;

    @FXML
    void initialize() {
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'loginscreen.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'loginscreen.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'loginscreen.fxml'.";
        assert signupButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'loginscreen.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'loginscreen.fxml'.";

    }

}
