package com.adaxator.controllers;

import com.adaxator.DbConnector.DbConnector;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class loginPaneController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    private PrimaryStackController primaryStackController;

    public void setprimaryStackController(PrimaryStackController primaryStackController) {
        this.primaryStackController = primaryStackController;
    }

    @FXML
    private void initialize() {
        System.out.println("Zainicjalizowane logInPaneV2");

    }

    @FXML
    private void menuAction() {
        primaryStackController.setMenu();
    }

    @FXML
    private void logInAcction() {
        if (DbConnector.queryLogIn(loginField, passwordField)) {
            System.out.println("Zalogowano");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("/fxmls/mainApp.fxml"));
            AnchorPane appPane = null;
            try {
                appPane = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (appPane != null) {
                primaryStackController.setLayout(appPane);

                MainAppController mainAppController = fxmlLoader.getController();
                mainAppController.setPrimaryStackController(this.primaryStackController);
                mainAppController.setUserName(loginField.getCharacters().toString());
            }
        }

    }


}
