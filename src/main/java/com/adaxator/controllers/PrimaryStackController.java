package com.adaxator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PrimaryStackController {
    @FXML
    private StackPane mainPane;


    @FXML
    private void initialize() {
        System.out.println("Inicjalizacja primaryStackPane");

    }

    public void setMenu() {
        FXMLLoader fxmlLoader = getFxmlLoaderMenu();
        Pane menuPane = null;
        try {
            menuPane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (menuPane != null) {

            MenuPaneController menuPaneController = fxmlLoader.getController();
            menuPaneController.setPrimaryStackController(this);
            menuPaneController.setDbLabel();


            setLayout(menuPane);

        }
    }

    private FXMLLoader getFxmlLoaderMenu() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxmls/menuPane.fxml"));
        return fxmlLoader;
    }

    public void setLayout(Node menuPane) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(menuPane);
    }




}
