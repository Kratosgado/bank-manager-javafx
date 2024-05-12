package com.bank.dashboard;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class DashboardScreen extends Scene {

    public DashboardScreen(Parent parent) {
        super(parent);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");

        MenuItem addAccount = new MenuItem("Add Account");
        MenuItem viewAccounts = new MenuItem("View Accounts");
        MenuItem logout = new MenuItem("Logout");

        menu.getItems().addAll(addAccount, viewAccounts, logout);
        menuBar.getMenus().add(menu);
        vBox.getChildren().add(menuBar);
        this.setRoot(vBox);
    }

}
