package com.bank;

// import com.bank.auth.LoginScreen;

import atlantafx.base.theme.PrimerDark;
// import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static Navigator navigator;
    // private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        // Application.setUserAgentStylesheet(new
        // PrimerLight().getUserAgentStylesheet());
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        

        navigator = new Navigator(primaryStage);
        this.initializeApp();
    }

    private void initializeApp() {
        navigator.pushFXML("launcher");
    }

    public static void main(String[] args) {
        launch(args);
    }
}