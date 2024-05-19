package com.bank;

import java.util.Stack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    private Stage stage;
    private final Stack<Screen> screenStack = new Stack<>();

    private final double HEIGHT = 720;
    private final double WIDTH = 1080;

    // inner class for each screen
    public static class Screen {
        public final String name;
        public final Scene scene;

        public Screen(String name, Scene scene) {
            this.name = name;
            this.scene = scene;
        }
    }

    public Navigator(Stage stage) {
        this.stage = stage;
        this.stage.setWidth(WIDTH);
        this.stage.setHeight(HEIGHT);
    }

    private Screen getCurrentScreen() {
        return screenStack.peek();
    }

    public void showCurrentScreen() {
        Navigator.Screen currentScreen = this.getCurrentScreen();
        stage.setScene(currentScreen.scene);
        stage.setTitle(currentScreen.name);
        stage.show();
    }

    public void pushScreen(String name, Scene scene) {
        final Screen screen = new Screen(name, scene);
        screenStack.push(screen);
        this.showCurrentScreen();
    }

    public void popScreen() {
        screenStack.pop();
        this.showCurrentScreen();
    }

    public void pushReplacement(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        try {
            final Scene scene = fxmlLoader.load();
            final Screen screen = new Screen(fxml, scene);
            screenStack.pop();
            screenStack.push(screen);
            this.showCurrentScreen();
        } catch (Exception e) {

            System.err.println(e.getLocalizedMessage());
        }

    }

    public void pushFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        try {
            final Scene scene = fxmlLoader.load();
            final Screen screen = new Screen(fxml, scene);
            screenStack.push(screen);
            this.showCurrentScreen();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public Stage getStage() {
        return this.stage;
    }

    public void changeStage(String fxml) {
        final FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        try {
            final Scene scene = fxmlLoader.load();
            final Screen screen = new Screen(fxml, scene);
            this.screenStack.clear();
            this.screenStack.push(screen);
            Stage newStage = new Stage();
            newStage.setWidth(WIDTH);
            newStage.setHeight(HEIGHT);
            this.stage = newStage;
            this.showCurrentScreen();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

    }
}
