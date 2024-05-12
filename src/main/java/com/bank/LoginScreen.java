package com.bank;

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

        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getStyleClass().add("root");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.getStyleClass().add("username-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("password-field");

        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("button");
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
