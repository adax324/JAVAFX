package com.adaxator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuPaneController {
    private primaryStackController primaryStackController;

    public void setPrimaryStackController(com.adaxator.controllers.primaryStackController primaryStackController) {
        this.primaryStackController = primaryStackController;
    }

    @FXML
    void logInButtonAction() {

    }
    @FXML
    void registerButtonAction(){
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxmls/registerPane.fxml"));
        Pane pane=null;
        try {
            pane=fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(pane!=null)
            primaryStackController.setPane(pane);

        RegisterController registerController=fxmlLoader.getController();
        registerController.setPrimaryStackController(this.primaryStackController);


    }
    @FXML
    void exitButtonAction(){

    }

    @FXML
    private void initialize() {
        System.out.println("Inicjalizacja Menu Pane");
    }
}
