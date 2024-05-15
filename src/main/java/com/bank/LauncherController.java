package com.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LauncherController {

    @FXML
    private Button goToLoginButton;

    @FXML
    void goToLoginScreen(ActionEvent event) {
        App.navigator.pushFXML("loginScreen");
    }

}
