package com.bank;

import java.util.HashMap;
import java.util.Stack;

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
    }

    public void showCurrentScreen() {
        Navigator.Screen currentScreen = this.getCurrentScreen();
        stage.setScene(currentScreen.scene);
        stage.setTitle(currentScreen.name);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
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

    private Screen getCurrentScreen() {
        return screenStack.peek();
    }
}
