package com.bank;

import com.bank.auth.LoginScreen;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static Navigator navigator;
    // private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        // Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        navigator = new Navigator(primaryStage);
        this.initializeApp();
    }

    private void initializeApp() {
        Button loginButton = new Button("Go to Login ");
        loginButton.setOnAction(event -> {
            LoginScreen loginScreen = new LoginScreen(new StackPane());
            navigator.pushScreen("Login Screen", loginScreen);
        });

        StackPane root = new StackPane();
        root.getChildren().add(loginButton);

        final Scene scene = new Scene(root);
        navigator.pushScreen("Home", scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}