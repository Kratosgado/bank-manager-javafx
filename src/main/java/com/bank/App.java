

package com.bank;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Click me");
        btn.setOnAction(event -> btn.setText("You clicked me!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 1080, 720);

        primaryStage.setTitle("Bank Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}