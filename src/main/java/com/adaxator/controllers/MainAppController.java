package com.adaxator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainAppController {
    private PrimaryStackController primaryStackController;
    private String userName;
    @FXML
    private TextField asd;
    @FXML
    private TextField asdf;
    @FXML
    private Label qwe;

    public void setUserName(String userName){
        this.userName=userName;
    }

    public void setPrimaryStackController(PrimaryStackController primaryStackController) {
        this.primaryStackController = primaryStackController;
    }
    @FXML
    private void initialize(){
        System.out.println("Inicjacja MainApp użytkownik: "

        );
        tempClass tempClass=new tempClass();
        asd.textProperty().bindBidirectional(tempClass.getStringProperty());
        qwe.visibleProperty().bindBidirectional(tempClass.getVisible());
    }
}
