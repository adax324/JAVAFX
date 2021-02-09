package com.adaxator.controllers;

import com.adaxator.DbConnector.DbConnector;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

public class MenuPaneController {
    @FXML
    private Label dbLabel;
    private primaryStackController primaryStackController;

    public void setPrimaryStackController(com.adaxator.controllers.primaryStackController primaryStackController) {
        this.primaryStackController = primaryStackController;
    }

    public void setDbLabel() {
        Connection connection = null;
        connection = DbConnector.connect();

        if (connection != null) {
            dbLabel.setText("Uzyskano połączenie z bazą danych");
            dbLabel.setVisible(true);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            dbLabel.setText("Brak połączenia z bazą danych");
            dbLabel.setVisible(true);
        }





    }

    @FXML
    void logInButtonAction() {

    }

    @FXML
    void registerButtonAction() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxmls/registerPane.fxml"));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pane != null)
            primaryStackController.setPane(pane);

        RegisterController registerController = fxmlLoader.getController();
        registerController.setPrimaryStackController(this.primaryStackController);


    }

    @FXML
    void exitButtonAction() {
        Platform.exit();

    }

    @FXML
    private void initialize() {
        System.out.println("Inicjalizacja Menu Pane");
    }
}
