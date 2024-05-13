package com.bank.auth;

import com.bank.App;
import com.bank.Styles;
import com.bank.dashboard.DashboardScreen;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LoginScreen extends Scene {

    public LoginScreen(Parent parent) {
        super(parent);

        // this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
    

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            System.out.println("Username: " + username);

            // navigate to dashboard screen
            DashboardScreen dashboardScreen = new DashboardScreen(new Pane());
            App.navigator.pushScreen("Dashboard", dashboardScreen);
        });

        vBox.getChildren().addAll(usernameField, passwordField, loginButton);

        this.setRoot(vBox);
    }

}
