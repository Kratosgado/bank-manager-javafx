package com.bank.auth;

import com.bank.App;

import atlantafx.base.theme.Styles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class LoginController {

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
    void handleLogin(ActionEvent event) {
        final String username = this.username.getText();
        final String password = this.password.getText();
        if (username.length() < 5 || password.length() < 6) {
            // make the border red
            // var tf2 = new TextField("Text");
            System.out.println("username must be more than 4");
            return;
        }
        App.navigator.pushFXML("dashboard");
    }

    @FXML
    void validateUsername(KeyEvent event) {
        if (this.username.getLength() < 5) {
            // make the border red
            this.username.pseudoClassStateChanged(Styles.STATE_DANGER, true);
            return;
        }
        this.username.pseudoClassStateChanged(Styles.STATE_SUCCESS, true);
        this.username.pseudoClassStateChanged(Styles.STATE_DANGER, false);

    }

    @FXML
    void validatePassword(KeyEvent event) {
        if (this.password.getLength() < 5) {
            // make the border red
            this.password.pseudoClassStateChanged(Styles.STATE_DANGER, true);
            return;
        }
        this.password.pseudoClassStateChanged(Styles.STATE_SUCCESS, true);
        this.password.pseudoClassStateChanged(Styles.STATE_DANGER, false);

    }
}
